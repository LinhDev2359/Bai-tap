package org.aibles.user_profile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.aibles.user_profile.constant.Gender;
import org.aibles.user_profile.entity.base.BaseEntity;

@Entity
@Table(name = "user_profile")
public class UserProfile extends BaseEntity {

  private String username;
  private String password;
  private String firstName;
  private String lastName;
  private Gender gender;
  private Integer dateOfBirth;
  private String phone;
  private String email;
  private String address;

  public UserProfile() {
  }

  public UserProfile(String username, String password, String firstName, String lastName, Gender gender, Integer dateOfBirth,
      String phone, String email, String address) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.dateOfBirth = dateOfBirth;
    this.phone = phone;
    this.email = email;
    this.address = address;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Integer getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Integer dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public static UserProfile of(String username, String password, String firstName, String lastName,
      Gender gender, Integer dateOfBirth, String phone, String email, String address) {
    UserProfile userProfile = new UserProfile();
    userProfile.setUsername(username);
    userProfile.setPassword(password);
    userProfile.setFirstName(firstName);
    userProfile.setLastName(lastName);
    userProfile.setGender(gender);
    userProfile.setDateOfBirth(dateOfBirth);
    userProfile.setPhone(phone);
    userProfile.setEmail(email);
    userProfile.setAddress(address);
    return userProfile;
  }

  public static UserProfile of(String username, String password, String email) {
    UserProfile userProfile = new UserProfile();
    userProfile.setUsername(username);
    userProfile.setPassword(password);
    userProfile.setEmail(email);
    return userProfile;
  }
}
