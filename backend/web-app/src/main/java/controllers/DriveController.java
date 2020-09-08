package controllers;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONArray;
import org.json.JSONObject;

import classModels.Drive;
import classModels.DriveType;
import services.DriveService;

public class DriveController {

  public DriveController(DriveService driveService) {

    AtomicInteger atomicIntegerDrive = new AtomicInteger(driveService.getAllDrives().size()+1);

    get("/api/drive/all", (request, response) -> {

			return new JSONArray(driveService.getAllDrives());
		});

		get("/api/drive/:name", (request, response) -> {			
			String driveName = request.params(":name");

			return new JSONObject(driveService.getDriveByName(driveName));
    });

    get("/api/drive/org/:orgId", (request, response) -> {			
			int orgId = Integer.parseInt(request.params(":orgId"));

			return new JSONArray(driveService.getDrivesFromOrg(orgId));
    });
    
    post("/api/drive/new", (request, response) -> {
      JSONObject requestData = new JSONObject(request.body());

      Drive drive = new Drive(atomicIntegerDrive.getAndIncrement(), requestData.getString("name"), 
        DriveType.valueOf(requestData.getString("type")), requestData.getInt("capacity"), requestData.getInt("vmId"));

      boolean added = driveService.addDrive(drive);

      if (!added) {
        response.status(400);
        JSONObject responseObject = new JSONObject();
        responseObject.put("message", "Drive with this name already exists");
        return responseObject;
      } 
      JSONObject responseObject = new JSONObject();
      responseObject.put("message", "Virtual machine drive successfully added");
      return responseObject;
 
    });

    put("/api/drive/update", (request, response) -> {
      JSONObject requestData = new JSONObject(request.body());

      boolean updated = driveService.updateDrive(requestData.getString("oldName"), requestData.getString("newName"), 
        requestData.getInt("capacity"), DriveType.valueOf(requestData.getString("type")), requestData.getInt("vmId"));

      if (!updated) {
        response.status(400);
        JSONObject responseObject = new JSONObject();
        responseObject.put("message", "Update failed");
        return responseObject;
      }

      JSONObject responseObject = new JSONObject();
      responseObject.put("message", "Update successful");
      return responseObject;
    });

    delete("/api/drive/:name", (request, response) -> {
      String name = request.params(":name");

      boolean deleted = driveService.deleteDrive(name);
      if (!deleted) {
        response.status(400);
      }

      return new JSONObject(deleted);

    });

  }
}