package org.aibles.user_profile.dto.response;


import java.util.List;
import java.util.stream.Collectors;
import org.aibles.user_profile.constant.Gender;
import org.aibles.user_profile.entity.UserProfile;

public class UserProfileResponse {

  private String id;
  private String firstName;
  private String lastName;
  private Gender gender;
  private int dateOfBirth;
  private String phone;
  private String email;
  private String address;
  private Long createdAt;
  private Long updatedAt;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  public int getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(int dateOfBirth) {
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

  public Long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  public Long getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Long updatedAt) {
    this.updatedAt = updatedAt;
  }

  public static UserProfileResponse from(UserProfile userProfile) {
    UserProfileResponse response = new UserProfileResponse();
    response.setId(userProfile.getId());
    response.setFirstName(userProfile.getFirstName());
    response.setLastName(userProfile.getLastName());
    response.setGender(userProfile.getGender());
    response.setDateOfBirth(userProfile.getDateOfBirth());
    response.setPhone(userProfile.getPhone());
    response.setEmail(userProfile.getEmail());
    response.setAddress(userProfile.getAddress());
    response.setCreatedAt(userProfile.getCreatedAt());
    response.setUpdatedAt(userProfile.getUpdatedAt());
    return response;
  }

  public static List<UserProfileResponse> from(List<UserProfile> userProfiles) {
    return userProfiles.stream()
        .map(UserProfileResponse::from)
        .collect(Collectors.toList());
  }
}
