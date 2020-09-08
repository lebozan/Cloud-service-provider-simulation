package services;

import java.util.ArrayList;

import Utility.DataCollectionManager;
import classDTOs.UserDTO;
import classModels.Role;
import classModels.User;

public class UserService {

	private DataCollectionManager collectionManager;


	public UserService() {
	}

	public UserService(DataCollectionManager collectionManager) {

		this.collectionManager = collectionManager;
	}

	public DataCollectionManager getCollectionManager() {

		return this.collectionManager;
	}

	public void setCollectionManager(DataCollectionManager collectionManager) {
		this.collectionManager = collectionManager;
	}

	public ArrayList<User> getAllUsers() {

		return collectionManager.getUsers();
	}

	public ArrayList<UserDTO> getAllUserDTOs() {

		return collectionManager.getUserDTOs();
	}

	public User getUserByEmail(String email) {

		return collectionManager.getUserByEmail(email);
	}

	public User getUserById(int userId) {

		return collectionManager.getUserById(userId);
	}

	public ArrayList<UserDTO> getUsersFromOrg(int orgId) {

		return collectionManager.getUsersFromOrg(orgId);
	}

	public boolean updateUser(String oldEmail, String newEmail, String firstname, String lastname, String password, Role role) {
		return collectionManager.updateUser(oldEmail, newEmail, firstname, lastname, password, role);
	}

	public boolean updatePassword(int userId, String newPassword) {
		return collectionManager.updateUserPassword(userId, newPassword);
	}

	public boolean deleteUserById(int id) {

		return collectionManager.deleteUserById(id);
	}

	public boolean deleteUserByEmail(String email) {

		return collectionManager.deleteUserByEmail(email);
	}

	public boolean addUser(User user) {

		return collectionManager.addUser(user);
	}


}
