package org.aibles.user_profile.exception;

public class OTPInvalidException extends BaseException{

  public OTPInvalidException(String otp) {
    setStatus(404);
    setCode("org.aibles.user_profile.exception.OTPInvalidException");
    addParams("OTP invalid: ", otp);
  }
}
