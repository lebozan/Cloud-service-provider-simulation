
import static spark.Spark.before;
import static spark.Spark.options;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Utility.DataCollectionManager;
import Utility.FileIOManager;
import controllers.CategoryController;
import controllers.DriveController;
import controllers.LoginController;
import controllers.OrganizationController;
import controllers.UserController;
import controllers.VirtualMachineController;
import services.CategoryService;
import services.DriveService;
import services.OrganizationService;
import services.SessionService;
import services.UserService;
import services.VirtualMachineService;
import spark.Session;

public class Main {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {


		enableCORS("http://localhost", "DELETE,GET,POST,PUT,OPTIONS,HEAD", "*");
//        enableCORS("http://localhost:63342", "DELETE,GET,POST,PUT,OPTIONS,HEAD", "*");


		ArrayList<Session> allSessions = new ArrayList<>();

		FileIOManager fileManager = new FileIOManager(true);

		DataCollectionManager collectionManager = new DataCollectionManager(fileManager, allSessions);

		UserService userService = new UserService(collectionManager);
		new LoginController(userService, new SessionService(collectionManager));
		new UserController(userService);
		new OrganizationController(new OrganizationService(collectionManager));
		new CategoryController(new CategoryService(collectionManager));
		new VirtualMachineController(new VirtualMachineService(collectionManager));
		new DriveController(new DriveService(collectionManager));
	}


	private static void enableCORS(final String origin, final String methods, final String headers) {

    options("/*", (request, response) -> {

        String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
        if (accessControlRequestHeaders != null) {
            response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
        }

        String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
        if (accessControlRequestMethod != null) {
            response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
        }

        return "OK";
    });

    before((request, response) -> {
        response.header("Access-Control-Allow-Origin", origin);
        response.header("Access-Control-Request-Method", methods);
        response.header("Access-Control-Allow-Headers", headers);
        response.header("Access-Control-Allow-Credentials", "true");
        response.type("application/json");
    });
}


}
