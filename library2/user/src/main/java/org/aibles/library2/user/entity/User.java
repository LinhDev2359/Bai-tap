package org.aibles.library2.user.entity;


import java.sql.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.aibles.library2.user.validation.BaseValidator;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "user_profile")

public class User extends BaseValidator<User> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "email", unique = true, length = 100)
  private String email;

  @Column(name = "password", unique = true, length = 20)
  @NotBlank
  private String password;

  @Column(name = "firstname", unique = true, length = 20)
  @NotBlank
  private String firstname;

  @Column(name = "lastname", unique = true, length = 20)
  @NotBlank
  private String lastname;

  @Column(name = "number_phone", unique = true, length = 15)
  @NotBlank
  private String numberPhone;

  @Column(name = "date_of_birth")
  @NotNull
  private Date dateOfBirth;

  @Column(name = "address", unique = true, length = 256)
  @NotBlank
  private String address;


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    User user = (User) o;
    return id != null && Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
