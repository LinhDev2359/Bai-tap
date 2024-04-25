package org.aibles.user_profile.repository;

import java.util.List;
import org.aibles.user_profile.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {

  List<Comment> findAllByPostId(String postId);
  List<Comment> findAllByParentId(String parentId);
  boolean existsByIdAndUserProfileIdAndPostId(String id, String userProfileId, String postId);

  @Query("update Comment c set c.content = :content where c.id = :id and c.postId  = :postId and c.userProfileId = :userProfileId")
  Comment updateContent(String id, String postId, String userProfileId,String content);
}
