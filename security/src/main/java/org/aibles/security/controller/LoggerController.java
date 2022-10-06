package org.aibles.security.controller;

import liquibase.repackaged.net.sf.jsqlparser.Model;
import lombok.extern.slf4j.Slf4j;
import org.aibles.security.dto.request.LoginRequest;
import org.aibles.security.dto.response.LoginResponse;
import org.aibles.security.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/loggers")
@Slf4j
public class LoggerController {

  public final LoginService service;

  public LoggerController(LoginService service) {
    this.service = service;
  }

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public String created(@RequestBody @Validated() LoginRequest loginRequest) {
    service.register(loginRequest);
    return "Create";
  }


}
