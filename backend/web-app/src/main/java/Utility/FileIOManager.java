package Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import classModels.Drive;
import classModels.DriveType;
import classModels.Organization;
import classModels.Role;
import classModels.User;
import classModels.VirtualMachine;
import classModels.VirtualMachineCategory;

public class FileIOManager {

  public FileIOManager() {

  }

  public FileIOManager(boolean initTestData) {
    if (initTestData) {
      this.writeTestData();
    }
  }

  public void writeUserToFile(ArrayList<User> users) {
    ObjectMapper mapper = new ObjectMapper();

    mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    try {
      mapper.writeValue(new File("src/main/resources/users.json"), users);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void writeVirtualMachinesToFile(ArrayList<VirtualMachine> vms) {
    ObjectMapper mapper = new ObjectMapper();

    mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    try {
      mapper.writeValue(new File("src/main/resources/vms.json"), vms);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void writeVirtualMachineCategoriesToFile(ArrayList<VirtualMachineCategory> vmcs) {
    ObjectMapper mapper = new ObjectMapper();

    mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    try {
      mapper.writeValue(new File("src/main/resources/vmcs.json"), vmcs);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void writeDrivesToFile(ArrayList<Drive> drives) {
    ObjectMapper mapper = new ObjectMapper();

    mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    try {
      mapper.writeValue(new File("src/main/resources/drives.json"), drives);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void writeOrganizationsToFile(ArrayList<Organization> orgs) {
    ObjectMapper mapper = new ObjectMapper();

    mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    try {
      mapper.writeValue(new File("src/main/resources/orgs.json"), orgs);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public ArrayList<User> readUserFromFile() {
    ArrayList<User> users = new ArrayList<>();

    ObjectMapper reader = new ObjectMapper();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader("src/main/resources/users.json"));

      List<User> fileData = reader.readValue(br, new TypeReference<List<User>>() {});
      users.addAll(fileData);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return users;
  }
  
  public ArrayList<VirtualMachine> readVirtualMachinesFromFile() {

    ArrayList<VirtualMachine> vms = new ArrayList<>();

    ObjectMapper reader = new ObjectMapper();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader("src/main/resources/vms.json"));

      List<VirtualMachine> fileData = reader.readValue(br, new TypeReference<List<VirtualMachine>>() {});
      vms.addAll(fileData);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return vms;
  }
  
  public ArrayList<VirtualMachineCategory> readVirtualMachineCategoriesFromFile() {
    ArrayList<VirtualMachineCategory> vmcs = new ArrayList<>();

    ObjectMapper reader = new ObjectMapper();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader("src/main/resources/vmcs.json"));

      List<VirtualMachineCategory> fileData = reader.readValue(br, new TypeReference<List<VirtualMachineCategory>>() {});
      vmcs.addAll(fileData);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return vmcs;
  }
  
  public ArrayList<Drive> readDrivesFromFile() {
    ArrayList<Drive> drives = new ArrayList<>();

    ObjectMapper reader = new ObjectMapper();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader("src/main/resources/drives.json"));

      List<Drive> fileData = reader.readValue(br, new TypeReference<List<Drive>>() {});
      drives.addAll(fileData);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return drives;
  }
  
  public ArrayList<Organization> readOrganizationsFromFile() {
    ArrayList<Organization> orgs = new ArrayList<>();

    ObjectMapper reader = new ObjectMapper();
    BufferedReader br;
    try {
      br = new BufferedReader(new FileReader("src/main/resources/orgs.json"));

      List<Organization> fileData = reader.readValue(br, new TypeReference<List<Organization>>() {});
      orgs.addAll(fileData);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return orgs;
  }

  public void writeTestData() {
    ArrayList<User> allUsers = new ArrayList<User>();
		ArrayList<Organization> allOrganizations = new ArrayList<Organization>();
		ArrayList<VirtualMachineCategory> allVMCategories = new ArrayList<VirtualMachineCategory>();
		ArrayList<VirtualMachine> allVirtualMachines = new ArrayList<VirtualMachine>();
		ArrayList<Drive> allDrives = new ArrayList<Drive>();

		User superAdmin = new User(1, "superadmin@mail.com", "Bojan", "Cakic", "Superadmin123", Role.SUPER_ADMIN, -1, null);
		allUsers.add(superAdmin);

		User admin = new User(2, "admin@mail.com", "Nikola", "Nikolic", "Admin123", Role.ADMIN, 1, null);
		allUsers.add(admin);

		User user = new User(3, "user@mail.com", "Petar", "Petrovic", "User123123", Role.USER, 1, null);
		allUsers.add(user);

		VirtualMachineCategory vmCategory1 = new VirtualMachineCategory("kategorija1", 4, 8, 0);
		VirtualMachineCategory vmCategory2 = new VirtualMachineCategory("kategorija2", 8, 16, 4);
		allVMCategories.add(vmCategory1);
		allVMCategories.add(vmCategory2);

		Drive drive1 = new Drive(1, "Disk1", DriveType.HDD, 500, 1);
		Drive drive2 = new Drive(2, "Disk2", DriveType.SSD, 480, 1);
		Drive drive3 = new Drive(3, "Disk3", DriveType.HDD, 1000, 2);
		Drive drive4 = new Drive(4, "Disk4", DriveType.SSD, 250, 2);
		Drive drive5 = new Drive(5, "Disk5", DriveType.HDD, 2000, 3);
		Drive drive6 = new Drive(6, "Disk6", DriveType.SSD, 480, 3);
		allDrives.add(drive1);
		allDrives.add(drive2);
		allDrives.add(drive3);
		allDrives.add(drive4);
		allDrives.add(drive5);
		allDrives.add(drive6);

		ArrayList<Drive> vm1Drives = new ArrayList<>();
		vm1Drives.addAll(Arrays.asList(drive1, drive2));

		ArrayList<Drive> vm2Drives = new ArrayList<>();
		vm2Drives.addAll(Arrays.asList(drive3, drive4));

		ArrayList<Drive> vm3Drives = new ArrayList<>();
		vm3Drives.addAll(Arrays.asList(drive5, drive6));

		VirtualMachine vm1 = new VirtualMachine(1, "virtualna 1", vmCategory1, vm1Drives);
		VirtualMachine vm2 = new VirtualMachine(2, "virtualna 2", vmCategory2, vm2Drives);
		VirtualMachine vm3 = new VirtualMachine(3, "virtualna 3", vmCategory2, vm3Drives);
		allVirtualMachines.add(vm1);
		allVirtualMachines.add(vm2);
		allVirtualMachines.add(vm3);

		ArrayList<User> org1Users = new ArrayList<>();
		org1Users.add(admin);
		org1Users.add(user);
		// ArrayList<User> org2Users = new ArrayList<>();

		ArrayList<VirtualMachine> org1Resources = new ArrayList<>();
		org1Resources.add(vm1);
		org1Resources.add(vm2);

		Organization org1 = new Organization(1, "organizacija1", "opis1", "../css/images/forsenE.png", org1Users, org1Resources);
		allOrganizations.add(org1);

		Organization org2 = new Organization(2, "organizacija2", "opis2", "../css/images/forsenE.png", null, null);
    allOrganizations.add(org2);
    

    ObjectMapper mapper = new ObjectMapper();

    mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    try {
      mapper.writeValue(new File("src/main/resources/users.json"), allUsers);
      mapper.writeValue(new File("src/main/resources/drives.json"), allDrives);
      mapper.writeValue(new File("src/main/resources/vms.json"), allVirtualMachines);
      mapper.writeValue(new File("src/main/resources/vmcs.json"), allVMCategories);
      mapper.writeValue(new File("src/main/resources/orgs.json"), allOrganizations);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  

}