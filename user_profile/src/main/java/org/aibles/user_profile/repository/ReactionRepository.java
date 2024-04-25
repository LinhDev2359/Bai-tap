package org.aibles.user_profile.repository;

import java.util.List;
import org.aibles.user_profile.constant.TypeReaction;
import org.aibles.user_profile.dto.response.ReactionResponse;
import org.aibles.user_profile.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, String> {

  boolean existsByType(TypeReaction type);

  @Query("update Reaction d set d.type = :type where d.id = :id and d.postId  = :postId and d.userProfileId = :userProfileId")
  void updateType(String id, String postId, String userProfileId, TypeReaction type);

  @Query("update Reaction d set d.type = :type where d.postId  = :postId")
  List<ReactionResponse> findAllByPostId(String postId);

  boolean existsByIdAndUserProfileIdAndPostId(String id, String userProfileId, String postId);
}
