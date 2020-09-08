package classModels;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Drive {
    private int id;
    private String name;
    private DriveType driveType;
    private int capacity;
    private int virtualMachineId;


    public Drive() {
    }

    public Drive(int id, String name, DriveType driveType, int capacity, int virtualMachineId) {
        this.id = id;
        this.name = name;
        this.driveType = driveType;
        this.capacity = capacity;
        this.virtualMachineId = virtualMachineId;
    }

    @JsonProperty("driveId")
    public int getId() {
        return this.id;
    }
    // @JsonProperty("driveId")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("driveName")
    public String getName() {
        return this.name;
    }
    // @JsonProperty("driveName")
    public void setName(String name) {
        this.name = name;
    }

    public DriveType getDriveType() {
        return this.driveType;
    }

    public void setDriveType(DriveType driveType) {
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

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", driveType='" + getDriveType() + "'" +
            ", capacity='" + getCapacity() + "'" +
            ", virtualMachineId='" + getVirtualMachineId() + "'" +
            "}";
    }

}