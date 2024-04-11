package org.aibles.user_profile.repository;

import java.util.List;
import org.aibles.user_profile.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {

  Boolean existsByUserProfileIdAndId(String userProfileId, String id);

  void deleteAllByUserProfileId(String userProfileId);

  List<Post> findAllByUserProfileId(String id);

  Boolean existsByTitle(String title);
}
