package org.aibles.transaction;

import lombok.extern.slf4j.Slf4j;
import org.aibles.transaction.dto.AccountRequest;
import org.aibles.transaction.dto.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/account")
public class AccountController {

  public final AccountService service;


  public AccountController(AccountService service) {
    this.service = service;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.CREATED)
  public MessageResponse transferMoney(@RequestBody AccountRequest request) throws Exception{
    log.info("(transferMoney)accountFrom: {}", request.getFromAccount());
    return service.transferMoney(request);
  }
}
