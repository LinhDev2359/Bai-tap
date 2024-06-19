package org.aibles.user_profile.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.entity.EventFailed;
import org.aibles.user_profile.event.SendEmailTemplateEvent;
import org.aibles.user_profile.repository.EventFailedRepository;
import org.aibles.user_profile.service.EventFailedService;

@Slf4j
@RequiredArgsConstructor
public class EventFailedServiceImpl implements EventFailedService {

  private final EventFailedRepository eventFailedRepository;

  @Override
  public void save(SendEmailTemplateEvent event) {
    log.info("(save) event: {}", event);
    eventFailedRepository.save(EventFailed.of(event.getEmail(), event.getOtp()));
  }
}
