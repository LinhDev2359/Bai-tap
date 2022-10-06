package org.aibles.student.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto implements Serializable {
    private long id_student;
    @NotNull
    @Size(max = 26)
    @Size(min = 2)
    private String surname_and_cushion;

    @NotNull
    @Size(max = 128)
    @Size(min = 2)
    private String name;


    private Integer date;

    @NotNull
    @Size(max = 20)
    @Size(min = 2)
    private String sex;

    @NotNull
    @Size(max = 26)
    @Size(min = 2)
    private String place_of_birth;


    private Integer id_class;
}
