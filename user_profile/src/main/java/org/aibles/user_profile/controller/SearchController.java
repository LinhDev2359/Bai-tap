package org.aibles.user_profile.controller;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.Response;
import org.aibles.user_profile.dto.response.PostResponse;
import org.aibles.user_profile.entity.Post;
import org.aibles.user_profile.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/search")
public class SearchController {

  private final PostService postService;

  @GetMapping("/posts")
  public List<Post> searchPostsParam(@RequestParam Map<String, String> paramsSearch) {
    log.info("(searchPosts)paramsSearch: {}", paramsSearch);
    return postService.findByCriteria(paramsSearch);
  }
}
