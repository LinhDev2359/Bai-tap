package org.aibles.user_profile.repository;

import org.aibles.user_profile.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {

  void deleteAllByPostId(String postId);
}
