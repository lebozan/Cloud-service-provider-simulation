package class_models;

import java.util.List;

public class Organization {
	private String name, description;
	private List<User> users;
	private List<Integer> resources;


	public Organization() {
	}

	public Organization(String name, String description, List<User> users, List<Integer> resources) {
		this.name = name;
		this.description = description;
		this.users = users;
		this.resources = resources;
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

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Integer> getResources() {
		return this.resources;
	}

	public void setResources(List<Integer> resources) {
		this.resources = resources;
	}

	@Override
	public String toString() {
		return "{" +
			" name='" + getName() + "'" +
			", description='" + getDescription() + "'" +
			", users='" + getUsers() + "'" +
			", resources='" + getResources() + "'" +
			"}";
	}

}
