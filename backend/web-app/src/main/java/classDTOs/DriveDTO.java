package classDTOs;

import classModels.Drive;

public class DriveDTO {
  private int id;
  private String name;
  private String driveType;
  private int capacity;
  private int virtualMachineId;

  public DriveDTO() {

  }

  public DriveDTO(Drive drive) {
    this.id = drive.getId();
    this.name = drive.getName();
    this.driveType = drive.getDriveType().toString();
    this.capacity = drive.getCapacity();
    this.virtualMachineId = drive.getVirtualMachineId();
  }


  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDriveType() {
    return this.driveType;
  }

  public void setDriveType(String driveType) {
    this.driveType = driveType;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public int getVirtualMachineId() {
    return this.virtualMachineId;
  }

  public void setVirtualMachineId(int virtualMachineId) {
    this.virtualMachineId = virtualMachineId;
  }



}