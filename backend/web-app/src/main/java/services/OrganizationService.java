package services;

import java.util.ArrayList;

import class_models.Organization;

public class OrganizationService {
  
  private ArrayList<Organization> organizations;

  public OrganizationService() {

  }

  public OrganizationService(ArrayList<Organization> organizations) {
    this.organizations = organizations;
  }

  public void addOrganization(Organization organization) {
    this.organizations.add(organization);
  }

  public ArrayList<Organization> getOrganizations() {
    return this.organizations;
  }

  public void setOrganizations(ArrayList<Organization> organizations) {
    this.organizations = organizations;
  }

}