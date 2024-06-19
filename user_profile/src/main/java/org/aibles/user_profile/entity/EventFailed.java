package org.aibles.user_profile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.aibles.user_profile.entity.base.BaseEntity;

@Data
@Table(name = "failed_event")
@Entity
public class EventFailed extends BaseEntity {

  private String email;
  private String otp;

  public static EventFailed of(String email, String otp) {
    EventFailed eventFailed = new EventFailed();
    eventFailed.setEmail(email);
    eventFailed.setOtp(otp);
    return eventFailed;
  }
}
