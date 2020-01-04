package controllers;

import services.OrganizationService;
import static spark.Spark.*;
import org.json.*;

import class_models.Organization;

public class OrganizationController {

  public OrganizationController() {

  }

  public OrganizationController(OrganizationService organizationService) {

    after((request, response) -> {
      response.header("Access-Control-Allow-Origin", "*");
      response.type("application/json");
    });

    get("/org/all", (req, res) -> {
      JSONArray jsonObject = new JSONArray(organizationService.getOrganizations());
      return jsonObject;
    });
    
    post("/org/new", (req, res) -> {
      
      JSONObject requestDataJson = new JSONObject(req.body());

      Organization newOrganization = new Organization(requestDataJson.getString("name"),
        requestDataJson.getString("description"), null, null);
      organizationService.addOrganization(newOrganization);

      JSONObject respoObject = new JSONObject();
      respoObject.put("message", "Organization successfully added.");
      return respoObject;
    });


  }
}