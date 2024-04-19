package org.aibles.user_profile.configuration;

import org.aibles.user_profile.service.EmailService;
import org.aibles.user_profile.service.impl.EmailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Configuration
public class EmailConfiguration {

  @Bean
  public EmailService emailService(JavaMailSender emailSender, SpringTemplateEngine templateEngine) {
    return new EmailServiceImpl(emailSender, templateEngine);
  }
}
