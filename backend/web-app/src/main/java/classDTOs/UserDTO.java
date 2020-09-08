package classDTOs;

import classModels.User;

public class UserDTO {
  private int userId, organizationId;
  private String email, firstname, lastname, role;

  public UserDTO() {

  }

  public UserDTO(User user) {
    this.userId = user.getId();
    this.email = user.getEmail();
    this.firstname = user.getFirstName();
    this.lastname = user.getLastName();
    this.role = user.getRole().toString();
    this.organizationId = user.getOrganization();
  }

  public UserDTO(int userId, int organizationId, String email, String firstname, String lastname, String role) {
    this.userId = userId;
    this.organizationId = organizationId;
    this.email = email;
    this.firstname = firstname;
    this.lastname = lastname;
    this.role = role;
  }

  public int getUserId() {
    return this.userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getOrganizationId() {
    return this.organizationId;
  }

  public void setOrganizationId(int organizationId) {
    this.organizationId = organizationId;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstname() {
    return this.firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return this.lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "{" +
      "userId:'" + getUserId() + "'" +
      ",organizationId:'" + getOrganizationId() + "'" +
      ",email:'" + getEmail() + "'" +
      ",firstname:'" + getFirstname() + "'" +
      ",lastname:'" + getLastname() + "'" +
      ",role:'" + getRole() + "'" +
      "}";
  }

}