package org.aibles.user_profile.repository;

import org.aibles.user_profile.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {

  Boolean existsByEmail(String email);
}
