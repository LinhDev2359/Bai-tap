package org.aibles.user_profile.event.listener;

import static org.aibles.user_profile.constant.RedisConstant.OTP_TTL_MINUTES;

import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.event.SendEmailTemplateEvent;
import org.aibles.user_profile.service.EmailService;
import org.aibles.user_profile.service.EventFailedService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SendEmailTemplateListener {

  private final EmailService emailService;
  private final EventFailedService eventFailedService;

  @EventListener
  public void handleRegister(SendEmailTemplateEvent event) {
    try {
      log.info("(handleRegister) event: {}", event);
      String email = event.getEmail();
      String otp = event.getOtp();
      String subject = "Send OTP for Active account";
      var param = new HashMap<String, Object>();
      param.put("otp", otp);
      param.put("otp_life", String.valueOf(OTP_TTL_MINUTES));
      emailService.send(subject, email, "mail-template", param);
    } catch (Exception e) {
      log.error("Failed to send email for event: {}", event, e);
      handleFailure(event, e);
    }
  }

  private void handleFailure(SendEmailTemplateEvent event, Exception e) {
    int maxRetries = 3;
    int attempt = 0;
    boolean success = false;
    while (attempt < maxRetries && !success) {
      try {
        log.info("(handleRegister) event: {}", event);
        String email = event.getEmail();
        String otp = event.getOtp();
        String subject = "Send OTP for Active account";
        var param = new HashMap<String, Object>();
        param.put("otp", otp);
        param.put("otp_life", String.valueOf(OTP_TTL_MINUTES));
        emailService.send(subject, email, "mail-template", param);
        success = true;
      } catch (Exception retryException) {
        attempt++;
        log.error("Retry {}/{} failed for event: {}", attempt, maxRetries, event, retryException);
      }
    }

    if (!success) {
      log.error("All retries failed for event: {}", event);
      saveFailedEvent(event);
    }
  }

  private void saveFailedEvent(SendEmailTemplateEvent event) {
    log.info("(saveFailedEvent)event: {}", event);
    eventFailedService.save(event);
  }
}
