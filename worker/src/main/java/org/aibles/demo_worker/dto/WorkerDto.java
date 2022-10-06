package org.aibles.demo_worker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkerDto implements Serializable {
    private long id;


    @NonNull
    @Size(max = 128)
    @Size(min = 2)
    private String name;


    private int date;
    private int years_of_work;


    @NonNull
    @Size(max = 200)
    @Size(min = 5)
    private String address;

    private double wage;
    private double allowance;
}
