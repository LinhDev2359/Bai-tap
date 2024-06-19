package org.aibles.user_profile.event;

import org.springframework.context.ApplicationEvent;

public class SendEmailTemplateEvent extends ApplicationEvent {

  private String email;
  private String otp;

  public SendEmailTemplateEvent(Object source, String email, String otp) {
    super(source);
    this.email = email;
    this.otp = otp;
  }

  public String getOtp() {
    return otp;
  }

  public void setOtp(String otp) {
    this.otp = otp;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
