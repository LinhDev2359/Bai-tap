package org.aibles.user_profile.service;

import java.util.Map;
import org.springframework.scheduling.annotation.Async;

public interface EmailService {

  @Async
  void send(String subject, String to, String template, Map<String, Object> properties);
}
