package org.aibles.user_profile.facade.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.facade.PostFacadeService;
import org.aibles.user_profile.facade.UserProfileFacadeService;
import org.aibles.user_profile.service.UserProfileService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
public class UserProfileFacadeServiceImpl implements UserProfileFacadeService {

  private final UserProfileService userProfileService;
  private final PostFacadeService postFacadeService;
  @Override
  @Transactional
  public void deleteById(String id) {
    log.info("(deleteById)id: {}", id);
    postFacadeService.deleteAllByUserProfileId(id);
    userProfileService.deleteById(id);
  }
}
