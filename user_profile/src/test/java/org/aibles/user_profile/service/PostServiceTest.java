package org.aibles.user_profile.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.response.PostResponse;
import org.aibles.user_profile.entity.Post;
import org.aibles.user_profile.exception.TitleAlreadyExistedException;
import org.aibles.user_profile.repository.PostRepository;
import org.aibles.user_profile.service.impl.PostServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostServiceTest {

  @Mock
  private PostRepository postRepository;

  @InjectMocks
  private PostServiceImpl postService;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  private Post mockPostEntity() {
    Post post = new Post();
    post.setId("1");
    post.setTitle("title");
    post.setAuthor("Ya lynk");
    post.setUserProfileId("1");
    post.setContent("content");
    return post;
  }

  @Test
  public void created_ShouldReturnResponse_WithValidRequest() throws Exception {

    var request = new PostCreateRequest();
    request.setTitle("title");
    request.setContent("content");
    request.setCategory("null");

    Post savedPost = mockPostEntity();

    when(postRepository.existsByTitle(any())).thenReturn(true);
    when(postRepository.save(any(Post.class))).thenReturn(savedPost);

    PostResponse response = postService.create("1", request, "Ya Lynk");

    //verify(postRepository).save(any(Post.class));

    assertEquals(savedPost.getTitle(), response.getTitle());
    assertEquals(savedPost.getContent(), response.getContent());
    assertEquals(savedPost.getAuthor(), response.getAuthor());
    assertEquals(savedPost.getCategory(), response.getCategory());
   // assertEquals(savedPost.getId(), response.getId());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  @Transactional
  public void created_ShouldReturnConflict_WithTitleIsConflict() throws Exception {

    var request = new PostCreateRequest();
    request.setTitle("title");
    request.setContent("content");
    request.setCategory("null");

    when(postRepository.existsByTitle(request.getTitle())).thenReturn(true);

    assertThrows(TitleAlreadyExistedException.class, () -> {
      postService.create("1", request, "Ya Lynk");
    });
    verify(postRepository, Mockito.never()).save(any(Post.class));

  }

}
