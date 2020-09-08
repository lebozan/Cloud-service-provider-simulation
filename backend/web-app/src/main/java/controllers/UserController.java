package controllers;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.*;
import classDTOs.UserDTO;
import classModels.Role;
import classModels.User;
import services.UserService;

public class UserController {

	public UserController(UserService userService) {

		AtomicInteger atomicInteger = new AtomicInteger(userService.getAllUsers().size()+1);

		get("/api/users/all", (request, response) -> {

			return new JSONArray(userService.getAllUserDTOs());
		});

		get("/api/users/:userId", (request, response) -> {			
			int userId = Integer.parseInt(request.params(":userId"));
			User user = userService.getUserById(userId);

			return new JSONObject(new UserDTO(user));

		});

		get("/api/users/email/:email", (request, response) -> {			
			String userEmail = request.params(":email");
			User user = userService.getUserByEmail(userEmail);

			return new JSONObject(user);

		});

		get("/api/users/org/:orgId", (request, response) -> {

			String orgId = request.params(":orgId");
			int orgIdInt = Integer.parseInt(orgId);
			
			JSONArray orgUsers = new JSONArray(userService.getUsersFromOrg(orgIdInt));
			return orgUsers;
		});

		post("/api/users/new", (request, response) -> {
			JSONObject newUserJson = new JSONObject(request.body());
			User newUser = new User(atomicInteger.getAndIncrement(), newUserJson.getString("email"),
				 newUserJson.getString("firstname"), newUserJson.getString("lastname"), newUserJson.getString("password"), 
				 Role.valueOf(newUserJson.getString("role")), Integer.parseInt(newUserJson.getString("org")),  new ArrayList<String>());

			userService.addUser(newUser);

			return new JSONObject(new UserDTO(newUser));
		});

		put("/api/users/update", (request, response) -> {
			JSONObject requestData = new JSONObject(request.body());
			String oldEmail = requestData.getString("oldEmail");
			String newEmail = requestData.getString("newEmail");
			String newFirstname = requestData.getString("firstname");
			String newLastname = requestData.getString("lastname");
			String newPassword = requestData.getString("password");
			Role newRole = Role.valueOf(requestData.getString("role"));

			boolean updated = userService.updateUser(oldEmail, newEmail, newFirstname, newLastname, newPassword, newRole);

			JSONObject responseJson = new JSONObject();
			if (updated) {
				responseJson.put("message", "User data changed successfully!");
			} else {
				response.status(400);
				responseJson.put("message", "User data not changed!");
			}
			return responseJson;

		});

		post("/api/users/:userId/profile", (request, response) -> {
			JSONObject requestData = new JSONObject(request.body());
			String oldEmail = requestData.getString("oldEmail");
			String newEmail = requestData.getString("newEmail");
			String newFirstname = requestData.getString("firstname");
			String newLastname = requestData.getString("lastname");
			String newPassword = requestData.getString("password");

			boolean updated = userService.updateUser(oldEmail, newEmail, newFirstname, newLastname, newPassword, null);
			
			JSONObject responseJson = new JSONObject();
			if (updated) {
				responseJson.put("message", "User data changed successfully!");
			} else {
				response.status(400);
				responseJson.put("message", "User data not changed!");
			}
			return responseJson;
		});

		post("/api/users/:userId/changePassword", (request, response) -> {
			int userId = Integer.parseInt(request.params(":userId"));
			JSONObject requestData = new JSONObject(request.body());
			JSONObject requestResponse = new JSONObject();

			User user = userService.getUserById(userId);
			if (user.getPassword().equals(requestData.getString("oldPassword"))) {
				if (userService.updatePassword(userId, requestData.getString("newPassword"))) {
					requestResponse.put("message", "Password successfully updated");
					return requestResponse;
				}
			}

			response.status(400);
			requestResponse.put("message", "Password not updated");
			return requestResponse;
			
		});

		delete("/api/users/delete/id/:userId", (request, response) -> {
			String deleteUserId = request.params(":userId");
			boolean deleted = userService.deleteUserById(Integer.parseInt(deleteUserId));
			
			if (deleted) {
				response.status(200); 
			} else {
				response.status(400);
			}
			return new JSONObject(deleted);
		});

		delete("/api/users/delete/email/:email", (request, response) -> {
			String deleteUserEmail = request.params(":email");
			boolean deleted = userService.deleteUserByEmail(deleteUserEmail);
			
			if (deleted) {
				response.status(200); 
			} else {
				response.status(400);
			}
			return new JSONObject(deleted);
		});
	}
	
	
}
