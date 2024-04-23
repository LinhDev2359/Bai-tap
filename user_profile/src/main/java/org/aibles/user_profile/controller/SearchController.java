package org.aibles.user_profile.controller;

import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.dto.Response;
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
  public Response searchPostsParam(@RequestParam Map<String, String> allParams) {
    log.info("(searchPosts)allParams: {}", allParams);
    return Response.of(HttpStatus.OK.value(), postService.findByCriteria(allParams));
  }
}
