package org.aibles.transaction;

import org.aibles.transaction.dto.AccountRequest;
import org.aibles.transaction.dto.MessageResponse;

public interface AccountService {

  public MessageResponse transferMoney(AccountRequest request) throws Exception;
}
