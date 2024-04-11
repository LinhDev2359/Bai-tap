package org.aibles.user_profile.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "of")
@Data
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Response<T> {
  private int status;
  private String statusMessage;
  private T data;
  private String timestamp;

  public static <T> Response<T> of(int status, String statusMessage, T data) {
    return Response.of(status, statusMessage, data, String.valueOf(LocalDateTime.now()));
  }

  public static <T> Response<T> of(int status, String statusMessage) {
    return Response.of(status, statusMessage, null, String.valueOf(LocalDateTime.now()));
  }

  public static Response of(int status, Object data) {
    return Response.of(status, String.valueOf(LocalDateTime.now()), data);
  }

  public static Response of(int status) {
    return Response.of(status, String.valueOf(LocalDateTime.now()), null);
  }

}
