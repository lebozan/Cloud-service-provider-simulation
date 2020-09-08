package controllers;

import services.SessionService;
import services.UserService;
import spark.Session;

import static spark.Spark.*;

import org.json.JSONObject;

import classDTOs.UserDTO;
import classModels.User;


public class LoginController {

  public LoginController() {

  }

  public LoginController(UserService userService, SessionService sessionService) {

    before("/api/*", (request, response) -> {
        boolean authenticated = false;
        String sessionId = request.cookie("sessionId");

        if (sessionService.hasSession(sessionId)){
            authenticated = true;
        }

        System.out.println(authenticated);
        if (!request.requestMethod().equals("OPTIONS")) {
            if (!authenticated) {
              halt(401, "You are not welcome here");
            }
        }

        });

    post("/login", (request, response) -> {
        JSONObject requestDataJson = new JSONObject(request.body());

        for (User user : userService.getAllUsers()) {
            if (user.getEmail().equals(requestDataJson.getString("email")) && user.getPassword().equals(requestDataJson.getString("password"))) {

                Session session = request.session(true);
                session.attribute("user", user);
                sessionService.addSession(session);

                JSONObject returnJsonObject = new JSONObject(new UserDTO(user));
                returnJsonObject.put("sessionId", session.id());
                return returnJsonObject;
            }
        }

        JSONObject responseJson = new JSONObject();
        responseJson.put("error", "User not found");
        response.status(400);
        return responseJson;
    });
    
    get("/api/logout", (request, response) -> {
      boolean removed = sessionService.removeSession(request.cookie("sessionId"));
      if (!removed) {
        response.status(400);
      }
      return new JSONObject();
    });
  }

}