package org.aibles.user_profile.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.request.PostUpdateRequest;
import org.aibles.user_profile.dto.response.PostResponse;
import org.aibles.user_profile.facade.PostFacadeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PostFacadeService postFacadeService;

  private final ObjectMapper objectMapper = new ObjectMapper();


  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void created_ShouldReturnResponse_WithValidRequest() throws Exception {
    var request = new PostCreateRequest();
    request.setTitle("title");
    request.setContent("content");
    request.setCategory("null");

    Mockito.when(postFacadeService.create("1", request)).thenReturn(new PostResponse());
    mockMvc.perform(
            post("/api/v1/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isCreated());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void created_ShouldReturnBadRequest_WhenTitleIsBlank() throws Exception {
    var request = new PostCreateRequest();
    request.setTitle("");
    request.setContent("content");
    request.setCategory("null");

    Mockito.when(postFacadeService.create("1", request)).thenReturn(new PostResponse());

    mockMvc.perform(
            post("/api/v1/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))

        )
        .andExpect(status().isBadRequest());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getById_ShouldReturnResponse_WhenIdIsValid() throws Exception {

    var response = new PostResponse();
    response.setId("1");
    response.setTitle("title");
    response.setContent("content");
    response.setCategory("null");

    Mockito.when(postFacadeService.getById("1", "1")).thenReturn(response);

    mockMvc.perform(
            get("/api/v1/posts/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getById_ShouldReturnNotFound_WhenIdIsNotFound() throws Exception {

    var response = new PostResponse();
    response.setId("1");
    response.setTitle("title");
    response.setContent("content");
    response.setCategory("null");

    Mockito.when(postFacadeService.getById("1", "")).thenReturn(response);
    mockMvc.perform(
            get("/api/v1/posts/")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getAll_ShouldReturnResponse_WhenIsValid() throws Exception {
    mockMvc.perform(
            get("/api/v1/posts")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void deleteById_ShouldReturnMessage_WhenIdIsValid() throws Exception {

    Mockito.doNothing().when(postFacadeService).deleteById("1", "1");

    mockMvc.perform(
            delete("/api/v1/posts/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void deleteById_ShouldReturnNotFound_WhenIdIsNotFound() throws Exception {

    Mockito.doNothing().when(postFacadeService).deleteById("1", null);

    mockMvc.perform(
            delete("/api/v1/posts/")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void updateById_ShouldReturnResponse_WhenIdIsValid() throws Exception {

    var request = new PostUpdateRequest();
    request.setTitle("title");
    request.setContent("content");
    request.setCategory("null");

    var response = new PostResponse();
    response.setId("1");
    response.setTitle("title");
    response.setContent("content");
    response.setCategory("null");

    Mockito.when(postFacadeService.updateById("1", "1", request)).thenReturn(response);

    mockMvc.perform(
            patch("/api/v1/posts/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void updateById_ShouldReturnBadRequest_WhenTitleIsBlank() throws Exception {

    var request = new PostUpdateRequest();
    request.setTitle("");
    request.setContent("content");
    request.setCategory("null");

    var response = new PostResponse();
    response.setId("1");
    response.setTitle("title");
    response.setContent("content");
    response.setCategory("null");

    Mockito.when(postFacadeService.updateById("1", "1", request)).thenReturn(response);

    mockMvc.perform(
            patch("/api/v1/posts/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isBadRequest());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void updateById_ShouldReturnNotFound_WhenIdIsNotFound() throws Exception {

    var request = new PostUpdateRequest();
    request.setTitle("title");
    request.setContent("content");
    request.setCategory("null");

    var response = new PostResponse();
    response.setId("1");
    response.setTitle("title");
    response.setContent("content");
    response.setCategory("null");

    Mockito.when(postFacadeService.updateById("1", "", request)).thenReturn(response);

    mockMvc.perform(
            patch("/api/v1/posts/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void sharePost_ShouldReturnResponse_WhenIdIsValid() throws Exception {

    var request = new PostUpdateRequest();
    request.setTitle("title");
    request.setContent("content");
    request.setCategory("null");

    var response = new PostResponse();
    response.setId("1");
    response.setTitle("title");
    response.setContent("content");
    response.setCategory("null");

    Mockito.when(postFacadeService.sharePost("1", "1", request)).thenReturn(response);

    mockMvc.perform(
            post("/api/v1/posts/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isCreated());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void sharePost_ShouldReturnBadRequest_WhenTitleIsBlank() throws Exception {

    var request = new PostUpdateRequest();
    request.setTitle("");
    request.setContent("content");
    request.setCategory("null");

    var response = new PostResponse();
    response.setId("1");
    response.setTitle("title");
    response.setContent("content");
    response.setCategory("null");

    Mockito.when(postFacadeService.sharePost("1", "1", request)).thenReturn(response);

    mockMvc.perform(
            post("/api/v1/posts/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isBadRequest());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void sharePost_ShouldReturnNotFound_WhenIdIsNotFound() throws Exception {

    var request = new PostUpdateRequest();
    request.setTitle("title");
    request.setContent("content");
    request.setCategory("null");

    var response = new PostResponse();
    response.setId("1");
    response.setTitle("title");
    response.setContent("content");
    response.setCategory("null");

    Mockito.when(postFacadeService.sharePost("1", "", request)).thenReturn(response);

    mockMvc.perform(
            post("/api/v1/posts/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isNotFound());
  }

}
