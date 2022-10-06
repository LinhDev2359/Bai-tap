package org.aibles.okr.entity;


import java.sql.Date;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Table(name = "user_profile")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "email", unique = true, length = 100)
  private String email;

  @Column(name = "password", unique = true, length = 20)
  private String password;

  @Column(name = "firstname", unique = true, length = 20)
  private String firstname;

  @Column(name = "lastname", unique = true, length = 20)
  private String lastname;

  @Column(name = "number_phone", unique = true, length = 15)
  private String numberPhone;

  @Column(name = "date_of_birth")
  private Date dateOfBirth;

  @Column(name = "address", unique = true, length = 256)
  private String address;

  @CreationTimestamp
  @Column(name = "created_at")
  private Instant createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Instant updatedAt;

//  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//  @JsonManagedReference
//  private List<Objective> objectiveList;


}
