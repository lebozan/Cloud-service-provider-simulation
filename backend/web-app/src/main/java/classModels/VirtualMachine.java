package classModels;

import java.util.ArrayList;

public class VirtualMachine {
	private int id;
	private String name;
	private VirtualMachineCategory category;
	private int numberOfCores, gbsOfRam, gpuCores;
	private ArrayList<Drive> drives;


	public VirtualMachine() {
	}

	public VirtualMachine(int id, String name, VirtualMachineCategory category, ArrayList<Drive> drives) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.numberOfCores = category.getNumberOfCores();
		this.gbsOfRam = category.getGbsOfRam();
		this.gpuCores = category.getGpuCores();
		this.drives = drives;
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

	public VirtualMachineCategory getCategory() {
		return this.category;
	}

	public void setCategory(VirtualMachineCategory category) {
		this.category = category;
		this.numberOfCores = category.getNumberOfCores();
		this.gbsOfRam = category.getGbsOfRam();
		this.gpuCores = category.getGpuCores();
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

	public ArrayList<Drive> getDrives() {
		return this.drives;
	}

	public void setDrives(ArrayList<Drive> drives) {
		this.drives = drives;
	}

	@Override
	public String toString() {
		return "{" +
			"id:'" + getId() + "'" +
			"name:'" + getName() + "'" +
			",category:'" + getCategory() + "'" +
			",numberOfCores:'" + getNumberOfCores() + "'" +
			",gbsOfRam:'" + getGbsOfRam() + "'" +
			",gpuCores:'" + getGpuCores() + "'" +
			",drives:'" + getDrives() + "'" +
			"}";
	}


}
