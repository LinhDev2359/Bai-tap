package org.aibles.transaction.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {

  private int fromAccount;
  private int toAccount;
  private int numberMoney;

}
