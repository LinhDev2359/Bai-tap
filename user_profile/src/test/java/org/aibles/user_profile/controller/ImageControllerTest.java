package org.aibles.user_profile.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aibles.user_profile.dto.request.ImageCreateRequest;
import org.aibles.user_profile.dto.request.ImageUpdateRequest;
import org.aibles.user_profile.dto.request.PostUpdateRequest;
import org.aibles.user_profile.dto.response.ImageResponse;
import org.aibles.user_profile.dto.response.PostResponse;
import org.aibles.user_profile.facade.ImageFacadeService;
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
public class ImageControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ImageFacadeService imageFacadeService;

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void created_ShouldReturnResponse_WithValidRequest() throws Exception {

    var request = new ImageCreateRequest();
    request.setImageUrl("testUrl");

    mockMvc.perform(
            post("/api/v1/posts/{id}/images", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isCreated());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void created_ShouldReturnBadRequest_WithImageUrlIsBlank() throws Exception {

    var request = new ImageCreateRequest();
    request.setImageUrl("");

    mockMvc.perform(
            post("/api/v1/posts/1/images")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isBadRequest());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void created_ShouldReturnBadRequest_WithPostIdIsBlank() throws Exception {

    var request = new ImageCreateRequest();
    request.setImageUrl("testUrl");

    mockMvc.perform(
            post("/api/v1/posts//images")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isBadRequest());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getById_ShouldReturnResponse_WithIsValid() throws Exception {

    mockMvc.perform(
            get("/api/v1/posts/{id}/images/1", 1)
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getById_ShouldReturnBadRequest_WithPostIdIsBlank() throws Exception {

    mockMvc.perform(
            get("/api/v1/posts//images/1" )
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isBadRequest());
  }


  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getAll_ShouldReturnResponse_WithIsValid() throws Exception {

    mockMvc.perform(
            get("/api/v1/posts/1/images" )
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void getAll_ShouldReturnNotFound_WithPostIdIsBlank() throws Exception {

    mockMvc.perform(
            get("/api/v1/posts//images" )
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void deleteById_ShouldReturnMessage_WhenIdIsValid() throws Exception {

    Mockito.doNothing().when(imageFacadeService).deleteById("1", "1", "1");

    mockMvc.perform(
            delete("/api/v1/posts/1/images/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void deleteById_ShouldReturnNotFound_WhenIdIsNotFound() throws Exception {

    mockMvc.perform(
            delete("/api/v1/posts/1/images/")
                .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void updateById_ShouldReturnResponse_WhenIdIsValid() throws Exception {

    var request = new ImageUpdateRequest();
    request.setImageUrl("testUrl");

    var response = new ImageResponse();
    response.setId("1");
    response.setImageUrl("testUrl");
    response.setPostId("1");

    Mockito.when(imageFacadeService.updateById("1", "1", "1", request)).thenReturn(response);

    mockMvc.perform(
            patch("/api/v1/posts/{id}/images/1", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isOk());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void updateById_ShouldReturnBadRequest_WhenTitleIsBlank() throws Exception {

    var request = new ImageUpdateRequest();
    request.setImageUrl("");

    var response = new ImageResponse();
    response.setId("1");
    response.setImageUrl("testUrl");
    response.setPostId("1");

    Mockito.when(imageFacadeService.updateById("1", "1", "1", request)).thenReturn(response);

    mockMvc.perform(
            patch("/api/v1/posts/{id}/images/1", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isBadRequest());
  }

  @Test
  @WithMockUser(username = "testUser", roles = {"USER"})
  public void updateById_ShouldReturnNotFound_WhenIdIsNotFound() throws Exception {

    var request = new ImageUpdateRequest();
    request.setImageUrl("testUrl");

    var response = new ImageResponse();
    response.setId("1");
    response.setImageUrl("testUrl");
    response.setPostId("1");

    Mockito.when(imageFacadeService.updateById("1", "1", "1", request)).thenReturn(response);

    mockMvc.perform(
            patch("/api/v1/posts/{id}/images/", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
        )
        .andExpect(status().isNotFound());
  }
}
