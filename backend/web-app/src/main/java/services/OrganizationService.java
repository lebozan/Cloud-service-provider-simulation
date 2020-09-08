package services;

import java.util.ArrayList;

import Utility.DataCollectionManager;
import classModels.Organization;

public class OrganizationService {
  
  private DataCollectionManager collectionManager;

  public OrganizationService() {

  }

  public OrganizationService(DataCollectionManager collectionManager) {

    this.collectionManager = collectionManager;
  }

  public DataCollectionManager getCollectionManager() {

    return this.collectionManager;
  }

  public void setCollectionManager(DataCollectionManager collectionManager) {
    this.collectionManager = collectionManager;
  }

  public ArrayList<Organization> getAllOrganizations() {

    return collectionManager.getOrganizations();
  }

  public Organization getOrganizationById(int orgId) {

    return collectionManager.getOrganizationById(orgId);
  }
  
  public Organization getOrganizationByName(String name) {

    return collectionManager.getOrganizationByName(name);
  }

  public boolean addOrganization(Organization organization) {

    return collectionManager.addOrganization(organization);
  }

  public boolean deleteOrganization(String name) {

    return collectionManager.deleteOrganization(name);
  }

  public boolean updateOrganization(String oldName, String newName, String newDescription, String newLogo) {

    return collectionManager.updateOrganization(oldName, newName, newDescription, newLogo);
  }

}