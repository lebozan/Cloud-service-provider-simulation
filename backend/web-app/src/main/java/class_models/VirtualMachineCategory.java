package class_models;

public class VirtualMachineCategory {
    private String name;
    private int numberOfCores, gbsOfRam, gpuCores;


    public VirtualMachineCategory() {
    }


    public VirtualMachineCategory(String name, int numberOfCores, int gbsOfRam, int gpuCores) {
        this.name = name;
        this.numberOfCores = numberOfCores;
        this.gbsOfRam = gbsOfRam;
        this.gpuCores = gpuCores;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCores() {
        return this.numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public int getGbsOfRam() {
        return this.gbsOfRam;
    }

    public void setGbsOfRam(int gbsOfRam) {
        this.gbsOfRam = gbsOfRam;
    }

    public int getGpuCores() {
        return this.gpuCores;
    }

    public void setGpuCores(int gpuCores) {
        this.gpuCores = gpuCores;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", numberOfCores='" + getNumberOfCores() + "'" +
            ", ram='" + getGbsOfRam() + "'" +
            ", gpuCores='" + getGpuCores() + "'" +
            "}";
    }

	

}
