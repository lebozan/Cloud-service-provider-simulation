package controllers;

import services.CategoryService;
import static spark.Spark.*;

import org.json.JSONArray;
import org.json.JSONObject;

import classModels.VirtualMachineCategory;

public class CategoryController {

  public CategoryController(CategoryService categoryService) {

    get("/api/category/all", (request, response) -> {

			return new JSONArray(categoryService.getAllCategories());
		});

		get("/api/category/:name", (request, response) -> {			
			String categoryName = request.params(":name");

			return new JSONObject(categoryService.getCategoryByName(categoryName));
    });
    
    post("/api/category/new", (request, response) -> {
      JSONObject requestData = new JSONObject(request.body());

      VirtualMachineCategory newVMCategory = new VirtualMachineCategory(requestData.getString("name"), 
        requestData.getInt("cores"), requestData.getInt("ram"), requestData.getInt("gpuCores"));

      boolean added = categoryService.addCategory(newVMCategory);

      if (!added) {
        response.status(400);
        JSONObject responseObject = new JSONObject();
        responseObject.put("message", "Category with this name already exists");
        return responseObject;
      } 
      JSONObject responseObject = new JSONObject(newVMCategory);
      responseObject.put("message", "Virtual machine category successfully added");
      return responseObject;
 
    });

    put("/api/category/update", (request, response) -> {
      JSONObject requestData = new JSONObject(request.body());

      boolean updated = categoryService.updateCategory(requestData.getString("oldName"), requestData.getString("newName"), 
      requestData.getInt("cores"), requestData.getInt("ram"), requestData.getInt("gpuCores"));

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

    delete("/api/category/:name", (request, response) -> {
      String name = request.params(":name");

      boolean deleted = categoryService.deleteCategory(name);
      if (!deleted) {
        response.status(400);
      }

      return new JSONObject(deleted);

    });
  }
}