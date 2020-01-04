package class_models;

import java.util.ArrayList;

public class User {
	
	private int id;
	private String email, firstName, lastName, password;
	private Role role;
	private Organization organization;
	private ArrayList<String> activityList;

	public User() {
	}



	public User(int id, String email, String firstName, String lastName, String password, Role role, Organization organization, ArrayList<String> activityList) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.organization = organization;
		this.activityList = activityList;
	}
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public ArrayList<String> getActivityList() {
		return this.activityList;
	}

	public void setActivityList(ArrayList<String> activityList) {
		this.activityList = activityList;
	}

	@Override
	public String toString() {
		return "{" +
			" email='" + getEmail() + "'" +
			", firstName='" + getFirstName() + "'" +
			", lastName='" + getLastName() + "'" +
			", role='" + getRole() + "'" +
			", organization='" + getOrganization() + "'" +
			", activityList='" + getActivityList() + "'" +
			"}";
	}


}
