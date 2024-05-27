package org.aibles.user_profile.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.aibles.user_profile.dto.request.CommentCreateRequest;
import org.aibles.user_profile.dto.request.CommentUpdateRequest;
import org.aibles.user_profile.dto.request.ReactionUpdateRequest;
import org.aibles.user_profile.dto.response.CommentResponse;
import org.aibles.user_profile.dto.response.ReactionResponse;
import org.aibles.user_profile.facade.CommentFacadeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class CommentControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CommentFacadeService commentFacadeService;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void created_ShouldReturnResponse_WithValidRequest() throws Exception {
    var request = new CommentCreateRequest();
    request.setContent("hello");
    request.setParentId(null);

    Mockito.when(commentFacadeService.create("1", "1", request)).thenReturn(new CommentResponse());
    mockMvc.perform(
            post("/api/v1/posts/1/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isCreated());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void created_ShouldReturnBadRequest_WithContentIsBlank() throws Exception {
    var request = new CommentCreateRequest();
    request.setContent("");
    request.setParentId(null);

    Mockito.when(commentFacadeService.create("1", "1", request)).thenReturn(new CommentResponse());
    mockMvc.perform(
            post("/api/v1/posts/1/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isBadRequest());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getAllByPostId_ShouldReturnResponse_WithIsValid() throws Exception {
    List<CommentResponse> responseList = new ArrayList<>();
    CommentResponse response = new CommentResponse();
    responseList.add(response);

    Mockito.when(commentFacadeService.getAllByPost("1")).thenReturn(responseList);

    mockMvc.perform(
            get("/api/v1/posts/1/comments")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0]").exists());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getAllByPostId_ShouldReturnNotFound_WithPostIdIsNotFound() throws Exception {
    List<CommentResponse> responseList = new ArrayList<>();
    CommentResponse response = new CommentResponse();
    responseList.add(response);

    Mockito.when(commentFacadeService.getAllByPost("1")).thenReturn(responseList);

    mockMvc.perform(
            get("/api/v1/posts//comments")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getAllByParentId_ShouldReturnResponse_WithIsValid() throws Exception {
    List<CommentResponse> responseList = new ArrayList<>();
    CommentResponse response = new CommentResponse();
    responseList.add(response);

    Mockito.when(commentFacadeService.getAllByParentId("1", "1")).thenReturn(responseList);

    mockMvc.perform(
            get("/api/v1/posts/1/comments/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0]").exists());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getAllByParentId_ShouldReturnNotFound_WithPostIdIsNotFound() throws Exception {
    List<CommentResponse> responseList = new ArrayList<>();
    CommentResponse response = new CommentResponse();
    responseList.add(response);

    Mockito.when(commentFacadeService.getAllByParentId("1", "1")).thenReturn(responseList);

    mockMvc.perform(
            get("/api/v1/posts//comments/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getAllByParentId_ShouldReturnNotFound_WithParentIdIsNotFound() throws Exception {
    List<CommentResponse> responseList = new ArrayList<>();
    CommentResponse response = new CommentResponse();
    responseList.add(response);

    Mockito.when(commentFacadeService.getAllByParentId("1", "1")).thenReturn(responseList);

    mockMvc.perform(
            get("/api/v1/posts/1/comments/")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void deleteById_ShouldReturnResponse_WithIsValid() throws Exception {

    Mockito.doNothing().when(commentFacadeService).deleteById("1", "1", "1");
    mockMvc.perform(
            delete("/api/v1/posts/1/comments/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void deleteById_ShouldReturnNotFound_WithCommentIdIsNotFound() throws Exception {
    Mockito.doNothing().when(commentFacadeService).deleteById("1", "1", "1");

    mockMvc.perform(
            delete("/api/v1/posts/1/comments/")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void deleteById_ShouldReturnNotFound_WithPostIdIsNotFound() throws Exception {
    Mockito.doNothing().when(commentFacadeService).deleteById("1", "1", "1");

    mockMvc.perform(
            delete("/api/v1/posts//comments/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void updateContent_ShouldReturnResponse_WithIsValid() throws Exception {
    var request = new CommentUpdateRequest();
    request.setContent("Lynk");

    Mockito.doNothing().when(commentFacadeService).updateContent(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.any(CommentUpdateRequest.class));

    mockMvc.perform(
            patch("/api/v1/posts/1/comments/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void updateContent_ShouldReturnNotFound_WithCommentIdIsNotFound() throws Exception {
    var request = new CommentUpdateRequest();
    request.setContent("Lynk");

    Mockito.doNothing().when(commentFacadeService).updateContent(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.any(CommentUpdateRequest.class));

    mockMvc.perform(
            patch("/api/v1/posts/1/comments/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void updateContent_ShouldReturnNotFound_WithPostIdIsNotFound() throws Exception {
    var request = new CommentUpdateRequest();
    request.setContent("Lynk");

    Mockito.doNothing().when(commentFacadeService)
        .updateContent(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
            Mockito.any(CommentUpdateRequest.class));

    mockMvc.perform(
            patch("/api/v1/posts//comments/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isNotFound());
  }
}
