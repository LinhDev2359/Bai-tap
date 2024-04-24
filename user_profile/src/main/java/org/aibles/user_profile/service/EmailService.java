package org.aibles.user_profile.service;

import java.util.List;
import java.util.Map;
import org.springframework.scheduling.annotation.Async;

public interface EmailService {

  @Async
  void send(String subject, String to, String template, Map<String, Object> properties);

  @Async
  void send(String subject, String to, String content, List<String> attachments);

}
