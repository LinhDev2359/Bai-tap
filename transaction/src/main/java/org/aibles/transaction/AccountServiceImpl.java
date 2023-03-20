package org.aibles.transaction;

import lombok.extern.slf4j.Slf4j;
import org.aibles.transaction.dto.AccountRequest;
import org.aibles.transaction.dto.MessageResponse;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
public class AccountServiceImpl implements AccountService{

  private final AccountRepository repository;

  public AccountServiceImpl(AccountRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public MessageResponse transferMoney(AccountRequest request) throws Exception{
    Account accoutFrom = repository.findByAccountNumber(request.getFromAccount());
    Account accoutTo = repository.findByAccountNumber(request.getToAccount());

    if(accoutFrom == null) {
      throw  new Exception("Ta khoản nguồn không tồn tại");
      //return new MessageResponse("Ta khoản nguồn không tồn tại");
    }
    if(accoutTo == null) {
      throw new Exception("Ta khoản đích không tồn tại");
      //return new MessageResponse("Ta khoản đích không tồn tại");
    }
    if(accoutFrom.getNumberMoneyAccount().compareTo(request.getNumberMoney()) < 0) {
      throw new Exception("Số dư của bạn không đủ");
      //return new MessageResponse("Số dư của bạn không đủ");
    }

    accoutFrom.setNumberMoneyAccount(accoutFrom.getNumberMoneyAccount() - request.getNumberMoney());
    accoutTo.setNumberMoneyAccount(accoutTo.getNumberMoneyAccount() + request.getNumberMoney());

    repository.save(accoutFrom);
    repository.save(accoutTo);

    MessageResponse message = new MessageResponse("Chuyển khoản thành công!");

    return message;
  }
}
