package services;

import java.util.ArrayList;
import java.util.List;

import class_models.User;

public class UserService {
	
	private ArrayList<User> userList;
	

	public UserService() {
	}

	public UserService(ArrayList<User> users) {
		this();
		this.userList = users;
	}


	public List<User> getAllUsers() {

		return getUserList();
	}

	public User getUser(String email) {
		for (User user : this.userList) {
			if (user.getEmail().equals(email)) {
				return user;
			}
		}

		return null;
	}

	public boolean updateUser(int id, String email, String firstname, String lastname, String password) {
		for (User user : userList) {
			if (user.getId() == id) {
				user.setId(id);
				user.setEmail(email);
				user.setFirstName(firstname);
				user.setLastName(lastname);
				user.setPassword(password);
				return true;
			}
		} 

		return false;
	}

	public boolean deleteUser(int id) {
		for (User user : this.userList) {
			if (user.getId() == id) {
				this.userList.remove(user);
				return true;
			}
		}

		return false;
	}

	public User addNewUser(User user) {
		this.getUserList().add(user);
		return user;
	}


	public ArrayList<User> getUserList() {
		return this.userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}


}
