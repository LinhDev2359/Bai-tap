package org.aibles.user_profile.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.request.ReactionCreateRequest;
import org.aibles.user_profile.dto.request.ReactionUpdateRequest;
import org.aibles.user_profile.dto.response.PostResponse;
import org.aibles.user_profile.dto.response.ReactionResponse;
import org.aibles.user_profile.exception.ReactionNotFountException;
import org.aibles.user_profile.exception.UserProfileIdNotFoundException;
import org.aibles.user_profile.facade.ReactionFacadeService;
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
public class ReactionControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ReactionFacadeService reactionFacadeService;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void created_ShouldReturnResponse_WithValidRequest() throws Exception {
    var request = new ReactionCreateRequest();
    request.setType("LIKE");

    Mockito.when(reactionFacadeService.create("1", "1", request)).thenReturn(new ReactionResponse());
    mockMvc.perform(
            post("/api/v1/posts/1/reactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isCreated());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void created_ShouldReturnBadRequest_WithTypeIsBlank() throws Exception {
    var request = new ReactionCreateRequest();
    request.setType("");

    Mockito.when(reactionFacadeService.create("1", "1", request)).thenReturn(new ReactionResponse());
    mockMvc.perform(
            post("/api/v1/posts/1/reactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isBadRequest());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void created_ShouldReturnBadRequest_WithTypeIsNotMatch() throws Exception {
    var request = new ReactionCreateRequest();
    request.setType("like like");

    Mockito.when(reactionFacadeService.create("1", "1", request)).thenReturn(new ReactionResponse());
    mockMvc.perform(
            post("/api/v1/posts/1/reactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isBadRequest());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getAll_ShouldReturnResponse_WithIsValid() throws Exception {
    List<ReactionResponse> responseList = new ArrayList<>();
    ReactionResponse response = new ReactionResponse();
    responseList.add(response);

    Mockito.when(reactionFacadeService.getAll("1")).thenReturn(responseList);
    mockMvc.perform(
            get("/api/v1/posts/1/reactions")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$[0]").exists());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getAll_ShouldReturnNotFound_WithPostIdIsNotFound() throws Exception {
    List<ReactionResponse> responseList = new ArrayList<>();
    ReactionResponse response = new ReactionResponse();
    responseList.add(response);

    Mockito.when(reactionFacadeService.getAll("1")).thenReturn(responseList);
    mockMvc.perform(
            get("/api/v1/posts//reactions")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void deleteById_ShouldReturnResponse_WithIsValid() throws Exception {

    Mockito.doNothing().when(reactionFacadeService).deleteById("1", "1", "1");
    mockMvc.perform(
            delete("/api/v1/posts/1/reactions/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void deleteById_ShouldReturnNotFound_WithReactionIdIsNotFound() throws Exception {
    Mockito.doNothing().when(reactionFacadeService).deleteById("1", "1", "1");

    mockMvc.perform(
            delete("/api/v1/posts/1/reactions/")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void deleteById_ShouldReturnNotFound_WithPostIdIsNotFound() throws Exception {
    Mockito.doNothing().when(reactionFacadeService).deleteById("1", "1", "1");

    mockMvc.perform(
            delete("/api/v1/posts//reactions/1")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void updateType_ShouldReturnResponse_WithIsValid() throws Exception {
    var request = new ReactionUpdateRequest();
    request.setType("LIKE");

    Mockito.doNothing().when(reactionFacadeService).updateType(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.any(ReactionUpdateRequest.class));

    mockMvc.perform(
            patch("/api/v1/posts/1/reactions/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void updateType_ShouldReturnNotFound_WithReactionIdIsNotFound() throws Exception {
    var request = new ReactionUpdateRequest();
    request.setType("LIKE");

    Mockito.doNothing().when(reactionFacadeService).updateType(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.any(ReactionUpdateRequest.class));

    mockMvc.perform(
            patch("/api/v1/posts/1/reactions/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void updateType_ShouldReturnNotFound_WithPostIdIsNotFound() throws Exception {
    var request = new ReactionUpdateRequest();
    request.setType("LIKE");

    Mockito.doNothing().when(reactionFacadeService)
        .updateType(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
            Mockito.any(ReactionUpdateRequest.class));

    mockMvc.perform(
            patch("/api/v1/posts//reactions/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isNotFound());
  }
}
