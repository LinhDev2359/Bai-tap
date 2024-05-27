package org.aibles.user_profile.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.aibles.user_profile.constant.TypeReaction;
import org.aibles.user_profile.exception.GenderInvalidBaseException;
import org.aibles.user_profile.exception.TypeInvalidBaseException;

@Slf4j
public class ReactionCreateRequest {

  @NotBlank(message = "Type cannot blank")
  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void validateType() {
    TypeReaction[] typeReactions = TypeReaction.values();
    boolean isValid = false;

    for (TypeReaction value : typeReactions) {
      if (value.name().equals(this.type)) {
        isValid = true;
        break;
      }
    }

    if (!isValid) {
      log.error("(validateType)type: {} invalid", this.type);
      throw new TypeInvalidBaseException(type);
    }
  }
}
