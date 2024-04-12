package org.aibles.user_profile.repository;

import java.util.Optional;
import org.aibles.user_profile.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {

  boolean existsByEmail(String email);
  boolean existsByUsername(String username);
  Optional<UserProfile> findByUsername(String username);
}
