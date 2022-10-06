package org.aibles.student.exeption.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionReponse {
    private String error;
    private String message;
    private Instant timeStamp;
}
