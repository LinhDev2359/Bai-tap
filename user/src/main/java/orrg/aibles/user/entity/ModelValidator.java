package orrg.aibles.user.entity;


import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ModelValidator<T> {
  private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory()
      .getValidator();
  public Map<String, Object> isValid() {
    var violations = VALIDATOR.validate(this);
    if (!violations.isEmpty()) {
      log.info("(isValid){} --> INVALID", this.getClass().getTypeName());
      for (var violation: violations) {
        log.error("(isValid){}: {}", getField(violation), violation.getMessage());
      }
    }
    return new HashMap<>();
  }

  private String getField(ConstraintViolation<ModelValidator<T>> violation) {
    return violation.getPropertyPath().toString();
  }

  public void validate() {
    var errorMap = new HashMap<String, Object>();

    var violations = VALIDATOR.validate(this);
    if (!violations.isEmpty()) {
      log.info("(isValid){} --> INVALID", this.getClass().getTypeName());
      for (var violation: violations) {
        log.error("(isValid){}: {}", getField(violation), violation.getMessage());
      }
    }

    if (!errorMap.isEmpty()) {
      throw new RuntimeException("invalid entity");
    }
  }

}
