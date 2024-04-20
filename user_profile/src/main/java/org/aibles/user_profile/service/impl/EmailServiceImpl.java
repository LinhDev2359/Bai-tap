package org.aibles.user_profile.service.impl;

import jakarta.mail.Message;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.constant.EmailConstant;
import org.aibles.user_profile.exception.InternalServerError;
import org.aibles.user_profile.service.EmailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

  private final JavaMailSender emailSender;
  private final TemplateEngine templateEngine;

  @Override
  public void send(String subject, String to, String template, Map<String, Object> properties) {
    log.info("(send)subject: {}, to: {}, template: {}, properties: {}", subject, to, template, properties);
    try {
      var message = emailSender.createMimeMessage();
      message.setRecipients(Message.RecipientType.TO, to);
      message.setSubject(subject);
      message.setContent(getContent(template, properties), EmailConstant.CONTENT_TYPE_TEXT_HTML);
      emailSender.send(message);
    } catch (Exception ex) {
      log.info("(send)subject: {}, to: {}, ex: {} ", subject, to, ex.getMessage());
      throw new InternalServerError();
    }
  }

  private String getContent(String template, Map<String, Object> properties) {
    var context = new Context();
    context.setVariables(properties);
    return templateEngine.process(template, context);
  }
}
