package org.aibles.user_profile.service;

import org.aibles.user_profile.event.SendEmailTemplateEvent;

public interface EventFailedService {

  void save(SendEmailTemplateEvent event);
}
