package org.aibles.user_profile.event.listener;

import static org.aibles.user_profile.constant.RedisConstant.OTP_TTL_MINUTES;

import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.aibles.user_profile.event.SendEmailTemplateEvent;
import org.aibles.user_profile.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendEmailTemplateListener {

  private final EmailService emailService;

  @EventListener
  public void handleRegister(SendEmailTemplateEvent event) {
    String email = event.getEmail();
    String otp = event.getOtp();
    String subject = "Send OTP for Active account";
    var param = new HashMap<String, Object>();
    param.put("otp", otp);
    param.put("otp_life", String.valueOf(OTP_TTL_MINUTES));
    emailService.send(subject, email, "mail-template", param);
  }
}
