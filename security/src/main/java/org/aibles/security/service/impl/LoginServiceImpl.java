package org.aibles.security.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.aibles.security.dto.request.LoginRequest;
import org.aibles.security.dto.response.LoginResponse;
import org.aibles.security.entity.Logger;
import org.aibles.security.exception.NotFoundBaseException;
import org.aibles.security.exception.UsernameExistedException;
import org.aibles.security.repository.LoginRepository;
import org.aibles.security.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Slf4j
public class LoginServiceImpl implements LoginService {

  private static final String TYPE_OF_OBJECT = "user";
  @Autowired
  public final LoginRepository repository;

  public LoginServiceImpl(LoginRepository repository) {
    this.repository = repository;
  }

  @Override
  @Transactional
  public void register(LoginRequest request) {
    log.info("(register)username : {}", request.getUsername());
    if (repository.existsByUsername(request.getUsername())) {
      throw new UsernameExistedException(request.getUsername());
    }
    Logger logger = request.toLogger();
    //logger.setEnabled(false);
    repository.save(logger);
  }

//  @Override
//  public Boolean validate(String appUserName, String appPassword, String basicAuthHeader) {
//    if(StringUtils.hasText(basicAuthHeader) && basicAuthHeader.toLowerCase().startsWith("basic")) {
//      String base64Credentials = basicAuthHeader.substring("Basic".length()).trim();
//      byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
//      String credentials = new String(credDecoded, StandardCharsets.UTF_8);
//
//      final String[] values = credentials.split(":", 2);
//      if (values.length == 2) {
//        String username = values[0];
//        String password = values[1];
//        if (appUserName.equals(username) && appPassword.equals(password)) {
//          return true;
//        }
//      }
//     }
//    return false;
//  }

  @Override
  public LoginResponse getByUsername(String username) {
    log.info("(getByUsername)username : {}", username);
    Logger logger =
        repository
            .findByUsername(username)
            .orElseThrow(() -> new NotFoundBaseException(username));
    return LoginResponse.from(logger);
  }
}
