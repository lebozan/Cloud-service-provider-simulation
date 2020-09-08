package classDTOs;

import java.util.ArrayList;

import classModels.Organization;
import classModels.User;
import classModels.VirtualMachine;

public class OrganizationDTO {
  private int organizationId;
	private String name, description, logo;
	private ArrayList<UserDTO> users;
  private ArrayList<VirtualMachine> resources;

  public OrganizationDTO() {

  }

  public OrganizationDTO(Organization organization) {
    this.organizationId = organization.getOrganizationId();
    this.name = organization.getName();
    this.description = organization.getDescription();
    this.logo = organization.getLogo();

    if (organization.getUsers() != null){
      ArrayList<UserDTO> usersDTOs = new ArrayList<>();
      for (User user : organization.getUsers()) {
        usersDTOs.add(new UserDTO(user));
      }
      this.users = usersDTOs;
    } 

    if (organization.getResources() != null){
      this.resources = organization.getResources();
    } 
    
  }

  

  public int getOrganizationId() {
    return this.organizationId;
  }

  public void setOrganizationId(int organizationId) {
    this.organizationId = organizationId;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getLogo() {
    return this.logo;
  }

  public void setLogo(String logo) {
    this.logo = logo;
  }


  public ArrayList<UserDTO> getUsers() {
    return this.users;
  }

  public void setUsers(ArrayList<UserDTO> users) {
    this.users = users;
  }

  public ArrayList<VirtualMachine> getResources() {
    return this.resources;
  }

  public void setResources(ArrayList<VirtualMachine> resources) {
    this.resources = resources;
  }

  @Override
  public String toString() {
    return "{" +
      "organizationId:'" + getOrganizationId() + "'" +
      ",name:'" + getName() + "'" +
      ",description:'" + getDescription() + "'" +
      ",users:'" + getUsers() + "'" +
      ",resources:'" + getResources() + "'" +
      "}";
  }

  

}
