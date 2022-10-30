package org.aibles.managerdailyplan.dto.response;

public class MessageDTOResponse {

  private String message;

  public MessageDTOResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
