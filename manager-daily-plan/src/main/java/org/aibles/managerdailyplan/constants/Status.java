package org.aibles.managerdailyplan.constants;

public enum Status {
  DONE,
  IN_PROCESS,
  NOT_COMPLETED;

  public static boolean check(String code) {
    for (Status status : Status.values()) {
      if (status.name().equals(code)) {
        return true;
      }
    }
    return false;
  }
}
