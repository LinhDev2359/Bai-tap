package org.aibles.user_profile.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Constraint(validatedBy = ValidateDate.DateValidation.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
public @interface ValidateDate {

  String message() default "Invalid date format, required ddMMyyyy";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  class DateValidation implements ConstraintValidator<ValidateDate, Integer> {
    @Override
    public void initialize(ValidateDate constraintAnnotation) {}

    @Override
    public boolean isValid(Integer date, ConstraintValidatorContext constraintValidatorContext) {
      if (date == null) {
        return false;
      }
      String dateStr = date.toString();
      if (dateStr.length() != 8) {
        return false;
      }
      String regexDate = "ddMMyyyy";
      SimpleDateFormat sdf = new SimpleDateFormat(regexDate);
      sdf.setLenient(false);

      try {
        sdf.parse(dateStr);
        return true;
      } catch (ParseException e) {
        return false;
      }
    }
  }
}
