package controllers;

import static spark.Spark.*;
import org.json.*;

import class_models.User;
import services.UserService;


public class UserController {

	public UserController(UserService userService) {

		after((request, response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			response.type("application/json");
		});

		get("/users/all", (req, res) -> {
			return new JSONArray(userService.getAllUsers());
		});

		post("/users/login", (req, res) -> {
			return new JSONObject(req.body());
		});

		post("/users/new", (req, res) -> {
			JSONObject newUserJson = new JSONObject(req.body());
			User newUser = new User();

			JSONObject responseJson = new JSONObject();
			responseJson.put("message", "User successfully added.");

			return responseJson;
		});

		post("/users/:id/profile", (req, res) -> {
			JSONObject requestData = new JSONObject(req.body());
			String newEmail = requestData.getString("email");
			String newFirstname = requestData.getString("firstname");
			String newLastname = requestData.getString("lastname");
			String newPassword = requestData.getString("password");
			int id = Integer.getInteger(req.params("id"));

			boolean updated = userService.updateUser(id, newEmail, newFirstname, newLastname, newPassword);
			
			JSONObject responseJson = new JSONObject();
			if (updated) {
				responseJson.put("message", "User data changed successfully!");
			} else {
				res.status(400);
				responseJson.put("message", "User data not changed!");
			}
			return responseJson;
		});

		delete("/users/delete/:id", (req, res) -> {
			String deleteUserId = req.params("id");
			boolean deleted = userService.deleteUser(Integer.getInteger(deleteUserId));
			
			if (deleted) {
				res.status(200); 
			} else {
				res.status(400);
			}
			return new JSONObject(deleted);
		});
	}
	
	
}
