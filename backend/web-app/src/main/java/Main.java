
import java.util.ArrayList;

import class_models.Organization;
import class_models.Role;
import class_models.User;
import controllers.OrganizationController;
import controllers.UserController;
import services.OrganizationService;
import services.UserService;
public class Main {

	public static void main(String[] args) {
		ArrayList<User> allUsers = new ArrayList<User>();
		ArrayList<Organization> allOrganizations = new ArrayList<Organization>();

		User superAdmin = new User(1, "cakicbojan@gmail.com", "Bojan", "Cakic","Sifra123", Role.SUPER_ADMIN, null, null);
		allUsers.add(superAdmin);
		
		Organization org1 = new Organization("org1", "opis1", null, null);
		allOrganizations.add(org1);

		Organization org2 = new Organization("org2", "opis2", null, null);
		allOrganizations.add(org2);

		new UserController(new UserService(allUsers));
		new OrganizationController(new OrganizationService(allOrganizations));
		
	}



}
