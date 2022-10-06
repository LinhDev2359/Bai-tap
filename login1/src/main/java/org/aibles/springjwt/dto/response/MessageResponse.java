package org.aibles.springjwt.dto.response;

import org.springframework.http.ResponseEntity.BodyBuilder;

public class MessageResponse {
  private String message;

  public MessageResponse(String message) {
    this.message = message;
  }


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
