package controllers;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONArray;
import org.json.JSONObject;

import classDTOs.OrganizationDTO;
import classModels.Organization;
import services.OrganizationService;

public class OrganizationController {

  public OrganizationController() {

  }

  public OrganizationController(OrganizationService organizationService) {

    AtomicInteger atomicInteger = new AtomicInteger(organizationService.getAllOrganizations().size()+1);

    get("/api/org/all", (request, response) -> {
      JSONArray jsonObject = new JSONArray(organizationService.getAllOrganizations());
      return jsonObject;
    });

    get("/api/org/:orgId", (request, response) -> {
      int orgId = Integer.parseInt(request.params(":orgId"));
      Organization org = organizationService.getOrganizationById(orgId);
      if (org != null) {
        return new JSONObject(new OrganizationDTO(org));
      } else {
        response.status(400);
      }

      return "";
    });
    
    post("/api/org/new", (request, response) -> {

      
      JSONObject requestDataJson = new JSONObject(request.body());
      
      Organization newOrganization = new Organization(atomicInteger.getAndIncrement(), requestDataJson.getString("name"),
        requestDataJson.getString("description"), requestDataJson.getString("logo"), null, null);
      organizationService.addOrganization(newOrganization);


      JSONObject responseObject = new JSONObject(new OrganizationDTO(newOrganization));
      responseObject.put("message", "Organization successfully added.");
      return responseObject;
    });


    put("/api/org/update", (request, response) -> {
      JSONObject requestData = new JSONObject(request.body());
      boolean updated = organizationService.updateOrganization(requestData.getString("oldName"), requestData.getString("newName"),
        requestData.getString("newDescription"), requestData.getString("newLogo"));

      JSONObject responseObject = new JSONObject();
      
      if (!updated) {
        response.status(400);
        responseObject.put("message", "Update failed");
      } else {
        responseObject.put("message", "Update successful");
      }
      return responseObject;
    });

    delete("/api/org/:name", (request, response) -> {
      String name = request.params(":name");

      JSONObject responseObject = new JSONObject();

      boolean deleted = organizationService.deleteOrganization(name);
      if (!deleted) {
        response.status(400);
        responseObject.put("message", "Delete failed");
      } else {
        responseObject.put("message", "Delete successful");
      }

      return responseObject;

    });

  }
}