package org.aibles.user_profile.facade;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.constant.Gender;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.response.PostResponse;
import org.aibles.user_profile.dto.response.UserProfileResponse;
import org.aibles.user_profile.entity.Post;
import org.aibles.user_profile.entity.UserProfile;
import org.aibles.user_profile.exception.BadRequestException;
import org.aibles.user_profile.exception.UserProfileIdNotFoundException;
import org.aibles.user_profile.service.ImageService;
import org.aibles.user_profile.service.PostService;
import org.aibles.user_profile.service.UserProfileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class PostFacadeServiceTest {

  @Autowired
  private MockMvc mockMvc;

  @Mock
  private UserProfileService userProfileService;

  @Mock
  private PostService postService;

  @Mock
  private ImageService imageService;

  @Mock
  private PostFacadeService postFacadeService;

  @Mock
  private MultipartFile file;

  private Path fileStorageLocation = Paths.get("E:\\\\anh");

  @BeforeEach
  public void setUp() throws Exception {
    Files.createDirectories(fileStorageLocation);
  }

  private PostCreateRequest postCreateRequest() {
    PostCreateRequest request = new PostCreateRequest();
    request.setTitle("Title");
    request.setContent("Content");
    request.setCategory("null");
    return request;
  }

  private UserProfileResponse userProfileResponse() {
    UserProfileResponse response = new UserProfileResponse();
    response.setId("1");
    response.setFirstName("Truong");
    response.setLastName("Linh");
    response.setGender(Gender.MALE);
    response.setDateOfBirth(2002);
    response.setPhone("123456789");
    response.setEmail("yalynk@example.com");
    response.setAddress("Ha Noi");
    response.setCreatedAt(System.currentTimeMillis());
    response.setUpdatedAt(System.currentTimeMillis());
    return response;
  }

  private PostResponse postResponse() {
    PostResponse response = new PostResponse();
    response.setId("2");
    response.setTitle("Sample Post Title");
    response.setContent("This is a sample post content.");
    response.setAuthor("YaLynk");
    response.setCategory("Sample Category");
    response.setParentId(null);
    response.setAuthorId(null);
    response.setUserProfileId("1");
    return response;
  }


  @Test
  public void create_ShouldReturnResponse_WithValidRequest() throws Exception {
    PostCreateRequest request = postCreateRequest();
    Mockito.when(userProfileService.getById("1")).thenReturn(userProfileResponse());
    Mockito.when(postService.create("1", request, "1")).thenReturn(new PostResponse());

    PostResponse mockResponse = new PostResponse();
    mockResponse.setId("1");
    mockResponse.setTitle("Title");
    mockResponse.setContent("Content");
    mockResponse.setCategory("null");

    Mockito.when(postFacadeService.create("1", request)).thenReturn(mockResponse);

    PostResponse response = postFacadeService.create("1", request);

    Assertions.assertEquals(request.getTitle(), response.getTitle());
    Assertions.assertEquals(request.getContent(), response.getContent());
    Assertions.assertEquals(request.getCategory(), response.getCategory());
  }

  @Test
  public void create_ShouldReturnNotFound_WithUserIdNotFound() throws Exception {
    PostCreateRequest request = postCreateRequest();

    Mockito.when(postFacadeService.create(Mockito.eq("1"), any(PostCreateRequest.class)))
        .thenThrow(new UserProfileIdNotFoundException("1"));

    Assertions.assertThrows(UserProfileIdNotFoundException.class, () ->
        postFacadeService.create("1", request));
  }

  @Test
  public void deleteById_ShouldReturnResponse_WithIsValid() throws Exception {
    Mockito.when(userProfileService.getById("1")).thenReturn(new UserProfileResponse());
    Mockito.doNothing().when(imageService).deleteAllByPostId("1");
    Mockito.doNothing().when(postService).deleteById("1");
    postFacadeService.deleteById("1", "1");
    Assertions.assertDoesNotThrow(() -> postFacadeService.deleteById("1", "1"));

  }

  @Test
  public void deleteAllByUserProfileId_ShouldReturnResponse_WithIsValid() throws Exception {

    String userProfileId = "1";
    Post post1 = new Post();
    post1.setId("post1");
    Post post2 = new Post();
    post2.setId("post2");

    List<Post> listPost = Arrays.asList(post1, post2);

    Mockito.when(postService.findAllByUserProfileId(userProfileId)).thenReturn(listPost);

    Mockito.doNothing().when(imageService).deleteAllByPostId(anyString());
    Mockito.doNothing().when(postService).deleteAllByUserProfileId(anyString());

    Assertions.assertDoesNotThrow(() -> postFacadeService.deleteAllByUserProfileId(userProfileId));
  }

  @Test
  public void sharePost_ShouldShareReturnResponse_WithValidRequest() throws Exception {

    String userProfileId = "1";
    String postId = "100";
    PostCreateRequest request = postCreateRequest();

    PostResponse expectedResponse = postResponse();

    Mockito.when(userProfileService.getById(userProfileId)).thenReturn(userProfileResponse());
    Mockito.when(postService.sharePost(userProfileId, postId, request, "YaLynk")).thenReturn(expectedResponse);

    PostResponse actualResponse = postFacadeService.sharePost(userProfileId, postId, request);

    Assertions.assertEquals(expectedResponse, actualResponse);
  }

  @Test
  public void uploadImage_ShouldShareReturnResponse_WithValidRequest() throws IOException {

    PostCreateRequest request = postCreateRequest();

    Mockito.when(userProfileService.getById("1")).thenReturn(userProfileResponse());
    Mockito.when(postService.create(anyString(), any(PostCreateRequest.class), anyString())).thenReturn(new PostResponse());
    Mockito.when(file.getOriginalFilename()).thenReturn("image.jpg");
    Mockito.when(file.getInputStream()).thenThrow(new RuntimeException());

    Assertions.assertDoesNotThrow(() -> {
      postFacadeService.uploadImage("1", request, file);
    });
  }
}
