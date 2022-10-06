package org.aibles.demo_worker.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;

    @Column (name="name")
    private String name;

    @Column (name="date")
    private int date;

    @Column (name="years_of_work")
    private int years_of_work;

    @Column (name="address")
    private String address;
    @Column (name="wage")
    private double wage;

    @Column (name="allowance")
    private double allowance;

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", years_of_work=" + years_of_work +
                ", address='" + address + '\'' +
                ", wage=" + wage +
                ", allowance=" + allowance +
                '}';
    }
}
