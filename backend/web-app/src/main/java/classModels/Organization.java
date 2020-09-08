package classModels;

import java.util.ArrayList;

public class Organization {
	private int organizationId;
	private String name, description, logo;
	private ArrayList<User> users;
	private ArrayList<VirtualMachine> resources;


	public Organization() {
	}


	public Organization(int organizationId, String name, String description, String logo, ArrayList<User> users, ArrayList<VirtualMachine> resources) {
		this.organizationId = organizationId;
		this.name = name;
		this.description = description;
		this.logo = logo;
		this.users = users;
		this.resources = resources;
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


	public ArrayList<User> getUsers() {
		return this.users;
	}

	public void setUsers(ArrayList<User> users) {
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
			"name:'" + getName() + "'" +
			",description:" + getDescription() + "'" +
			",users:" + getUsers() +
			",resources:" + getResources() +
			"}";
	}

}
