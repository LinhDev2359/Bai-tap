package org.aibles.user_profile.event;

import static org.aibles.user_profile.constant.RedisConstant.OTP_TTL_MINUTES;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.event.listener.SendEmailTemplateListener;
import org.aibles.user_profile.service.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SendEmailTemplateListenerTest {

  @Mock
  private EmailService emailService;

  @InjectMocks
  private SendEmailTemplateListener listener;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testHandleSendEmailTemplateEvent_Failure() {

    SendEmailTemplateEvent event = new SendEmailTemplateEvent(this, "test@example.com", "123456");
    String email = event.getEmail();
    String otp = event.getOtp();
    String subject = "Send OTP for Active account";

    Map<String, Object> param = new HashMap<>();
    param.put("otp", otp);
    param.put("otp_life", String.valueOf(3));
    // Giả lập lỗi khi gửi email
    doThrow(new RuntimeException("Failed to send email")).when(emailService).send(subject, email, "mail-template", param);

    listener.handleRegister(event);
    verify(emailService, times(1)).send(subject, email, "mail-template", param);
  }

}
