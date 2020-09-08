package classModels;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class User {
	
	private int id;
	private String email, firstName, lastName, password;
	private Role role;
	private int organization;
	private ArrayList<String> activityList;

	public User() {
	}

	public User(int id, String email, String firstName, String lastName, String password, Role role, int organization, ArrayList<String> activityList) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.organization = organization;
		this.activityList = activityList;
	}
	
	@JsonProperty("userId")
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("firstName")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("lastName")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonProperty("role")
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@JsonProperty("organizationId")
	public int getOrganization() {
		return this.organization;
	}

	public void setOrganization(int organization) {
		this.organization = organization;
	}

	@JsonProperty("activities")
	public ArrayList<String> getActivityList() {
		return this.activityList;
	}

	public void setActivityList(ArrayList<String> activityList) {
		this.activityList = activityList;
	}

	@Override
	public String toString() {
		return "{" +
			" email:'" + getEmail() + "'" +
			",firstName:'" + getFirstName() + "'" +
			",lastName:'" + getLastName() + "'" +
			",role:'" + getRole() + "'" +
			",organization:'" + getOrganization() + "'" +
			",activityList:'" + getActivityList() + "'" +
			"}";
	}


}
