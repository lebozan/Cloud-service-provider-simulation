package class_models;

public class Drive {
    private String name;
    private DriveType driveType;
    private int capacity;
    private VirtualMachine vmReference;


    public Drive() {
    }

    public Drive(String name, DriveType driveType, int capacity, VirtualMachine vmReference) {
        this.name = name;
        this.driveType = driveType;
        this.capacity = capacity;
        this.vmReference = vmReference;
    }

    public String getName() {
        return this.name;
    }

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

    public VirtualMachine getVmReference() {
        return this.vmReference;
    }

    public void setVmReference(VirtualMachine vmReference) {
        this.vmReference = vmReference;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", driveType='" + getDriveType() + "'" +
            ", capacity='" + getCapacity() + "'" +
            ", vmReference='" + getVmReference() + "'" +
            "}";
    }

}