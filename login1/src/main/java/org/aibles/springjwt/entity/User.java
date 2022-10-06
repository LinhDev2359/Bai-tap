package org.aibles.springjwt.entity;

import java.sql.Date;
import java.time.Instant;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "\"user\"",
    uniqueConstraints = { 
      @UniqueConstraint(columnNames = "email")
    })
@ToString
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @Email
  @Size(max = 20)
  private String email;

  @Size(max = 120)
  private String password;

  @Size(max = 20)
  private String firstName;

  @Size(max = 20)
  private String lastName;

  @Size(max = 15)
  @Column(name = "number_phone")
  private String numberPhone;

  @Column(name = "date_of_birth")
  private Date dateOfBirth;

  @Size(max = 256)
  private String address;

  @CreationTimestamp
  @Column(name = "created_at")
  private Instant createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Instant updatedAt;


  public User() {
  }

  public User(String email, String password, String firstName, String lastName,
      String numberPhone,
      Date dateOfBirth, String address) {
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.numberPhone = numberPhone;
    this.dateOfBirth = dateOfBirth;
    this.address = address;

  }

  public User(String email, String firstName, String lastName, String password) {
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }

}
