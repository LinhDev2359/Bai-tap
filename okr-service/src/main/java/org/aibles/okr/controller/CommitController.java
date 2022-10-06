package org.aibles.okr.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.okr.dto.request.commit.CreateCommit;
import org.aibles.okr.dto.response.CommitResponse;
import org.aibles.okr.service.CommitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/commits")
@Slf4j
public class CommitController {

  private final CommitService service;

  @Autowired
  public CommitController(CommitService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CommitResponse created(@RequestBody @Valid CreateCommit createCommit) {
    return service.created(createCommit);
  }

}
