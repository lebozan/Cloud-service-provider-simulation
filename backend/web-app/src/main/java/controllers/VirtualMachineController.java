package controllers;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONArray;
import org.json.JSONObject;

import classModels.Organization;
import classModels.VirtualMachine;
import classModels.Drive;
import services.VirtualMachineService;


public class VirtualMachineController {

  public VirtualMachineController(VirtualMachineService vmService) {

    AtomicInteger atomicInteger = new AtomicInteger(vmService.getVirtualMachines().size()+1);
    
    get("/api/vm/all", (request, response) -> {
      return new JSONArray(vmService.getVirtualMachines());
    });

    get("/api/vm/org/all", (request, response) -> {
      ArrayList<Organization> orgs = vmService.getCollectionManager().getOrganizations();
      ArrayList<VirtualMachine> vmsWithOrgId = new ArrayList<>();
      for (Organization o : orgs) {
        // vmsWithOrgId.addAll();
      }
      return new JSONArray(vmsWithOrgId);
    });

    get("/api/vm/:vmId", (request, response) -> {
      String vmId = request.params(":vmId");

      VirtualMachine vm = vmService.getVmById(Integer.parseInt(vmId));

      if (vm == null) {
        response.status(400);
      }

      return new JSONObject();
    });


    post("/api/vm/new", (request, response) -> {

      JSONObject requestData = new JSONObject(request.body());

      VirtualMachine virtualMachine = new VirtualMachine(atomicInteger.getAndIncrement(), requestData.getString("name"), 
      vmService.getCollectionManager().getCategoryByName(requestData.getString("categoryName")), new ArrayList<Drive>());

      boolean added = vmService.addVirtualMachine(virtualMachine, requestData.getInt("orgId"));

      JSONObject responseObject = new JSONObject();

      if (!added) {
        response.status(400);
        responseObject.put("message", "Virtual machine with this name already exists");
      } else {
        responseObject.put("message", "Virtual machine successfully added");
      }
      return responseObject;
 
    });

    put("/api/vm/update", (request, response) -> {
      JSONObject requestData = new JSONObject(request.body());

      boolean updated = vmService.updateVirtualMachine(requestData.getString("oldName"), requestData.getString("newName"), 
        vmService.getCollectionManager().getCategoryByName(requestData.getString("categoryName")), requestData.getInt("orgId"));

      JSONObject responseObject = new JSONObject();
      
      if (!updated) {
        response.status(400);
        responseObject.put("message", "Update failed");
      } else {
        responseObject.put("message", "Update successful");
      }
      return responseObject;
    });

    delete("/api/vm/:name", (request, response) -> {
      String name = request.params(":name");

      boolean deleted = vmService.deleteVirtualMachine(name);
      if (!deleted) {
        response.status(400);
      }

      return new JSONObject(deleted);

    });

  }
}