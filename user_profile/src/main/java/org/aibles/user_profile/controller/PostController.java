package org.aibles.user_profile.controller;

import static org.aibles.user_profile.constant.UserProfileApiConstant.BaseUrl.POST_URL;
import static org.aibles.user_profile.constant.UserProfileApiConstant.BaseUrl.USER_PROFILE_URL;
import static org.aibles.user_profile.constant.UserProfileApiConstant.ResourceConstant.POST;
import static org.aibles.user_profile.util.SecurityService.getUserId;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.Response;
import org.aibles.user_profile.dto.request.PostCreateRequest;
import org.aibles.user_profile.dto.request.PostUpdateRequest;
import org.aibles.user_profile.dto.response.PostImageResponse;
import org.aibles.user_profile.dto.response.PostResponse;
import org.aibles.user_profile.facade.PostFacadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(POST_URL)
public class PostController {


  private final PostFacadeService service;

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public PostResponse create(@Validated @RequestBody PostCreateRequest request) {
    log.info("(create)request: {}", request);
    return service.create(getUserId(), request);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PostResponse getById(@Validated @PathVariable("id") String id) {
    log.info("(getById)id: {}", id);
    return service.getById(getUserId(), id);
  }

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<PostResponse> getAll() {
    log.info("(getAll)");
    return service.getAll(getUserId());
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteById(@Validated @PathVariable("id") String id) {
    log.info("(deleteById)id: {}", id);
    service.deleteById(getUserId(), id);
    return "DELETE SUCCESS!!!";
  }


  @PatchMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public PostResponse updateById(@Validated @PathVariable("id") String id,
      @Validated @RequestBody PostUpdateRequest request) {
    log.info("(updateById)id: {}, request: {}", id, request);
    return service.updateById(id, getUserId(), request);
  }

  @PostMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public PostResponse sharePost(@Validated @PathVariable("id") String id,
      @Validated @RequestBody PostUpdateRequest request) {
    log.info("(sharePost)id: {}, request: {}", id, request);
    return service.sharePost(getUserId(), id, request);
  }

  @PostMapping("/upload")
  @ResponseStatus(HttpStatus.OK)
  public PostImageResponse uploadImage(
      @RequestParam(name = "file") MultipartFile file, @RequestParam(name = "title") String title,
      @RequestParam(name = "content") String content, @RequestParam(name = "category") String category) {
    log.info("(uploadImage)fileName: {}", file.getOriginalFilename());
    return service.uploadImage(getUserId(), PostCreateRequest.of(title, content, category), file);

  }
}
