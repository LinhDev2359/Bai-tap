package org.aibles.user_profile.service.impl;

import jakarta.mail.Message;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.constant.EmailConstant;
import org.aibles.user_profile.exception.InternalServerError;
import org.aibles.user_profile.service.EmailService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
      log.error("(send)subject: {}, to: {}, ex: {} ", subject, to, ex.getMessage());
      throw new InternalServerError();
    }
  }

  @Override
  public void send(String subject, String to, String content, List<String> attachments) {
    log.info("(send)subject: {}, to: {}, content: {}, attachments: {}", subject, to, content, attachments);
    try {
      var message = emailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);

      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(content);

      for (String filePath : attachments) {
        FileSystemResource file = new FileSystemResource(new File(filePath));
        helper.addAttachment(Objects.requireNonNull(file.getFilename()), file);
      }

      emailSender.send(message);
    } catch (Exception ex) {
      log.error("(send)subject: {}, to: {}, ex: {}", subject, to, ex.getMessage());
      throw new InternalServerError();
    }
  }

  private String getContent(String template, Map<String, Object> properties) {
    var context = new Context();
    context.setVariables(properties);
    return templateEngine.process(template, context);
  }
}
