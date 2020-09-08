package services;

import java.util.ArrayList;

import Utility.DataCollectionManager;
import classDTOs.DriveDTO;
import classModels.Drive;
import classModels.DriveType;


public class DriveService {
  private DataCollectionManager collectionManager;

  public DriveService() {

  }

  public DriveService(DataCollectionManager collectionManager) {

    this.collectionManager = collectionManager;
  }

  public DataCollectionManager getCollectionManager() {

    return this.collectionManager;
  }

  public void setCollectionManager(DataCollectionManager collectionManager) {
    this.collectionManager = collectionManager;
  }

  public ArrayList<Drive> getAllDrives() {

    return collectionManager.getDrives();
  }

  public ArrayList<DriveDTO> getAllDriveDTOs() {

    return collectionManager.getDriveDTOs();
  }

  public Drive getDriveByName(String name) {

    return collectionManager.getDriveByName(name);
  }

  public ArrayList<DriveDTO> getDrivesFromOrg(int orgId) {

    return collectionManager.getDrivesFromOrg(orgId);
  }

  public boolean addDrive(Drive drive) {

    return collectionManager.addDrive(drive);
  }

  public boolean deleteDrive(String name) {

    return collectionManager.deleteDrive(name);
  }

  public boolean updateDrive(String oldName, String newName, int capacity, DriveType driveType, int virtualMachineId) {

    return collectionManager.updateDrive(oldName, newName, capacity, driveType, virtualMachineId);
  }


}