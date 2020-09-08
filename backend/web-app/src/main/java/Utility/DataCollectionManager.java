package Utility;

import java.util.ArrayList;

import classDTOs.DriveDTO;
import classDTOs.OrganizationDTO;
import classDTOs.UserDTO;
import classModels.Drive;
import classModels.DriveType;
import classModels.Organization;
import classModels.Role;
import classModels.User;
import classModels.VirtualMachine;
import classModels.VirtualMachineCategory;
import spark.Session;

public class DataCollectionManager {

  private ArrayList<User> users;
  private ArrayList<VirtualMachine> virtualMachines;
  private ArrayList<Session> sessions;
  private ArrayList<Organization> organizations;
  private ArrayList<Drive> drives;
  private ArrayList<VirtualMachineCategory> virtualMachineCategories;
  private FileIOManager fileManager;

  public DataCollectionManager() {

  }

  public DataCollectionManager(FileIOManager fileManager, ArrayList<Session> sessions) {
    this.fileManager = fileManager;
    this.users = fileManager.readUserFromFile();
    this.virtualMachines = fileManager.readVirtualMachinesFromFile();
    this.sessions = sessions;
    this.organizations = fileManager.readOrganizationsFromFile();
    this.drives = fileManager.readDrivesFromFile();
    this.virtualMachineCategories = fileManager.readVirtualMachineCategoriesFromFile();
    
  }


  public ArrayList<User> getUsers() {
    return this.users;
  }

  public ArrayList<UserDTO> getUserDTOs() {
    ArrayList<UserDTO> dtos = new ArrayList<>();
    for (User u : users) {
      dtos.add(new UserDTO(u));
    }
    return dtos;
  }

  public void setUsers(ArrayList<User> users) {
    this.users = users;
  }

  public ArrayList<VirtualMachine> getVirtualMachines() {
    return this.virtualMachines;
  }

  public void setVirtualMachines(ArrayList<VirtualMachine> virtualMachines) {
    this.virtualMachines = virtualMachines;
  }

  public ArrayList<Session> getSessions() {
    return this.sessions;
  }

  public void setSessions(ArrayList<Session> sessions) {
    this.sessions = sessions;
  }

  public ArrayList<Organization> getOrganizations() {
    return this.organizations;
  }

  public ArrayList<OrganizationDTO> getOrganizationDTOs() {
    ArrayList<OrganizationDTO> dtos = new ArrayList<>();
    for (Organization o : organizations) {
      dtos.add(new OrganizationDTO(o));
    }
    return dtos;
  }

  public void setOrganizations(ArrayList<Organization> organizations) {
    this.organizations = organizations;
  }

  public ArrayList<Drive> getDrives() {
    return this.drives;
  }

  public ArrayList<DriveDTO> getDriveDTOs() {
    ArrayList<DriveDTO> dtos = new ArrayList<>();
    for (Drive d : drives) {
      dtos.add(new DriveDTO(d));
    }
    return dtos;
  }

  public void setDrives(ArrayList<Drive> drives) {
    this.drives = drives;
  }

  public ArrayList<VirtualMachineCategory> getVirtualMachineCategories() {
    return this.virtualMachineCategories;
  }

  public void setVirtualMachineCategories(ArrayList<VirtualMachineCategory> virtualMachineCategories) {
    this.virtualMachineCategories = virtualMachineCategories;
  }

  public FileIOManager getFileManager() {
    return this.fileManager;
  }

  public void setFileManager(FileIOManager fileManager) {
    this.fileManager = fileManager;
  }


  public boolean checkIfNameAvailable(String name, String collection) {

    switch (collection) {
      case "u":
        for (User user : this.users) {
          if (user.getEmail().equals(name)) {
            return false;
          }
        }
        return true;

      case "vm":
        for (VirtualMachine virtualMachine : this.virtualMachines) {
          if (virtualMachine.getName().equals(name)) {
            return false;
          }
        }
        return true;

      case "vmc":
        for (VirtualMachineCategory virtualMachineCategory : this.virtualMachineCategories) {
          if (virtualMachineCategory.getName().equals(name)) {
            return false;
          }
        }
        return true;

      case "d":
        for (Drive drive : this.drives) {
          if (drive.getName().equals(name)) {
            return false;
          }
        }
        return true;

      case "o":
        for (Organization organization : this.organizations) {
          if (organization.getName().equals(name)) {
            return false;
          }
        }
        return true;

      default:
        return false;
    }

  }

  public User getUserById(int userId) {
		for (User user : this.users) {
			if (user.getId() == userId) {
				return user;
			}
		}

		return null;
  }
  
  public ArrayList<UserDTO> getUsersFromOrg(int orgId) {
		ArrayList<UserDTO> orgUsers = new ArrayList<>();
		
		for(User user : this.users) {
			if (user.getOrganization() == orgId) {
				orgUsers.add(new UserDTO(user));
			}
		}

		return orgUsers;
  }
  
  public User getUserByEmail(String email) {
		for (User user : this.users) {
			if (user.getEmail().equals(email)) {
				return user;
			}
		}

		return null;
  }
  
  public boolean updateUserPassword(int userId, String newPassword) {
    boolean success = false;

    for (User user : this.users) {
			if (user.getId() == userId) {
				user.setPassword(newPassword);
				
				success = true;
			}
    }
    

    if (success) {
      fileManager.writeUserToFile(this.users);
    }

    return success;


  }

  public boolean deleteUserById(int id) {
    boolean success = false;
    
		for (User user : this.users) {
			if (user.getId() == id) {
				this.users.remove(user);
				success = true;
			}
		}

    if (success) {
      fileManager.writeUserToFile(this.users);
    }

    return success;
  }
  
  public boolean deleteUserByEmail(String email) {
    boolean success = false;

		for (User user : this.users) {
			if (user.getEmail().equals(email)) {
				this.users.remove(user);
				success = true;
			}
		}

    if (success) {
      fileManager.writeUserToFile(this.users);
    }

    return success;
  }
  
  public boolean addUser(User user) {
    boolean success = false;

    if (checkIfNameAvailable(user.getEmail(), "u")) {
      this.users.add(user);
      success = true;
    }
    
    if (success) {
      fileManager.writeUserToFile(this.users);
    }

    return success;
  }
  
  public VirtualMachine getVmById(int id) {
    for (VirtualMachine virtualMachine : this.virtualMachines) {
      if (virtualMachine.getId() == id) {
        return virtualMachine;
      }
    }

    return null;
  }

  public VirtualMachine getVmByName(String name) {
    for (VirtualMachine virtualMachine : this.virtualMachines) {
      if (virtualMachine.getName().equals(name)) {
        return virtualMachine;
      }
    }

    return null;
  }

  public boolean updateUser(String oldEmail, String newEmail, String firstname, String lastname, String password, Role role) {
    boolean success = false;
    
    for (User user : this.users) {
			if (user.getEmail().equals(oldEmail)) {
				if (newEmail != null) {
					user.setEmail(newEmail);
				}

				if (firstname != null) {
					user.setFirstName(firstname);
				}

				if (lastname != null) {
					user.setLastName(lastname);
				}

				if (password != null) {
					user.setPassword(password);
				}

				if (role != null) {
					user.setRole(role);
				}
				
				success = true;
			}
		} 

    if (success) {
      fileManager.writeUserToFile(this.users);
    }

    return success;
  }
  
  public boolean addVirtualMachine(VirtualMachine virtualMachine, int organizationId) {
    boolean success = false;
    
    if (checkIfNameAvailable(virtualMachine.getName(), "vm")) {
      this.virtualMachines.add(virtualMachine);
      for (Organization org : this.organizations) {
        if (org.getOrganizationId() == organizationId) {
          org.getResources().add(virtualMachine);
        }
      }
      success = true;
    } 

    if (success) {
      fileManager.writeOrganizationsToFile(this.organizations);
      fileManager.writeVirtualMachinesToFile(this.virtualMachines);
    }

    return success;
  }

  public boolean deleteVirtualMachine(String name) {
    boolean success = false;
    int deletedVMId = -1;

    for (VirtualMachine virtualMachine : this.virtualMachines) {
      if (virtualMachine.getName().equals(name)) {
        this.virtualMachines.remove(virtualMachine);
        deletedVMId = virtualMachine.getId();
        success = true;
        break;
      }
    }

    if (success) {
      for (Organization org : this.organizations) {
        for (VirtualMachine vm : org.getResources()) {
          if (vm.getName().equals(name)) {
            org.getResources().remove(vm);
            break;
          }
        }
      }

      for (Organization org : this.organizations) {
        for (VirtualMachine vm : org.getResources()) {
          for (Drive d : vm.getDrives()) {
            if (d.getVirtualMachineId() == deletedVMId) {
              d.setVirtualMachineId(-1);
            }
          }
        }
      }
      
      for (Drive d : this.drives) {
        if (d.getVirtualMachineId() == deletedVMId) {
          d.setVirtualMachineId(-1);
        }
      }

    }


    if (success) {
      fileManager.writeDrivesToFile(this.drives);
      fileManager.writeOrganizationsToFile(this.organizations);
      fileManager.writeVirtualMachinesToFile(this.virtualMachines);
    }

    return success;
  }

  public boolean updateVirtualMachine(String oldName, String newName, VirtualMachineCategory newCategory, int organizationId) {
    boolean success = false;

    for (VirtualMachine virtualMachine : this.virtualMachines) {
      if (virtualMachine.getName().equals(oldName) && !oldName.equals(newName)) {
        if (checkIfNameAvailable(newName, "vm")) {
          virtualMachine.setName(newName);
          virtualMachine.setCategory(newCategory);
          success = true;
        } else {
          success = false;
        }
      } else {
        virtualMachine.setCategory(newCategory);
        success = true;
      }
    }

    for (Organization org : this.organizations) {
      for (VirtualMachine vm : org.getResources()) {
        if (vm.getName().equals(oldName) && !oldName.equals(newName)) {
          if (checkIfNameAvailable(newName, "vm")) {
            vm.setName(newName);
            vm.setCategory(newCategory);
            success = true;
          } else {
            success = false;
          }
        } else {
          vm.setCategory(newCategory);
          success = true;
        }
      }
    }
    
    if (success) {
      fileManager.writeVirtualMachinesToFile(this.virtualMachines);
      fileManager.writeOrganizationsToFile(this.organizations);
    }

    return success;
  }

  public boolean hasSession(String sessionId) {
    for (Session session : this.sessions) {
      if (session.id().equals(sessionId)) {
        return true;
      }
    }

    return false;
  }

  public boolean addSession(Session session) {
    return this.sessions.add(session);
  }

  public boolean removeSession(String sessionId) {
    for (Session session : this.sessions) {
      if (session.id().equals(sessionId)) {
        this.sessions.remove(session);
        return true;
      }
    }

    return false;
  }

  public Organization getOrganizationById(int orgId) {
    for (Organization organization : this.organizations) {
      if (organization.getOrganizationId() == orgId) {
        return organization;
      }
    }
    return null;
  }

  public Organization getOrganizationByName(String name) {
    for (Organization organization : this.organizations) {
      if (organization.getName().equals(name)) {
        return organization;
      }
    }
    return null;
  }

  public boolean addOrganization(Organization organization) {
    boolean success = false;

    if (checkIfNameAvailable(organization.getName(), "o")) {
      this.organizations.add(organization);
      success = true;
    } 

    if (success) {
      fileManager.writeOrganizationsToFile(this.organizations);
    }

    return success;
  }

  public boolean deleteOrganization(String name) {
    boolean success = false;

    for (Organization organization : this.organizations) {
      if (organization.getName().equals(name)) {
        this.organizations.remove(organization);
        success = true;
      }
    }

    if (success) {
      fileManager.writeOrganizationsToFile(this.organizations);
    }

    return success;
  }

  public boolean updateOrganization(String oldName, String newName, String newDescription, String newLogo) {
    boolean success = false;

    for (Organization organization : this.organizations) {
      if (organization.getName().equals(oldName) && !oldName.equals(newName)) {
        if (checkIfNameAvailable(newName, "o")) {
          organization.setName(newName);
          organization.setDescription(newDescription);
          organization.setLogo(newLogo);
          success = true;
        } else {
          success = false;
        }
      } else {
        organization.setDescription(newDescription);
        organization.setLogo(newLogo);
        success = true;
      }
    }

    if (success) {
      fileManager.writeOrganizationsToFile(this.organizations);
    }

    return success;
  }


  public Drive getDriveByName(String name) {
    for (Drive drive : drives) {
      if (drive.getName().equals(name)) {
        return drive;
      }
    }
    return null;
  }

  public ArrayList<DriveDTO> getDrivesFromOrg(int orgId) {
    ArrayList<DriveDTO> orgDrives = new ArrayList<>();
    
    for (Organization organization : this.organizations) {
      if (organization.getOrganizationId() == orgId) {
        for (VirtualMachine vm : organization.getResources()) {
          for (Drive d : vm.getDrives()) {
            orgDrives.add(new DriveDTO(d));
          }
        }
      }
    }

    return orgDrives;
  }
  

  public boolean addDrive(Drive drive) {
    boolean success = false;
    if (checkIfNameAvailable(drive.getName(), "d")) {
      this.drives.add(drive);
      success = true;
    }

    if (success) {
      fileManager.writeDrivesToFile(this.drives);
    }
    return success;
  }

  public boolean deleteDrive(String name) {
    boolean success = false;
    String deletedName = "";
    int deletedVmId = 0;
    for (Drive drive : this.drives) {
      if (drive.getName().equals(name)) {
        this.drives.remove(drive);
        deletedName = drive.getName();
        deletedVmId = drive.getVirtualMachineId();
        success = true;
        break;
      }
    }

    if (success) {
      removeDriveReferences(deletedName, deletedVmId);
      fileManager.writeVirtualMachinesToFile(this.virtualMachines);
      fileManager.writeDrivesToFile(this.drives);
      fileManager.writeOrganizationsToFile(this.organizations);
    }
    return success;
  }

  private void removeDriveReferences(String driveName, int vmId) {
    boolean removed = false;
    for (Organization o : this.organizations) {
      for (VirtualMachine vm : o.getResources()) {
        for (Drive d : vm.getDrives()) {
          if (d.getName().equals(driveName)) {
            vm.getDrives().remove(d);
            removed = true;
            break;
          }
        }
        if (removed) {
          break;
        }
      }
      if (removed) {
        break;
      }
    }

    VirtualMachine vm = getVmById(vmId);
    for (Drive d : vm.getDrives()) {
      if (d.getName().equals(driveName)) {
        vm.getDrives().remove(d);
        break;
      }
    }
  }


  public boolean updateDrive(String oldName, String newName, int capacity, DriveType driveType, int virtualMachineId) {
    for (Drive drive : this.drives) {
      if (drive.getName().equals(oldName) && !oldName.equals(newName)) {
        if (checkIfNameAvailable(newName, "d")) {
          drive.setName(newName);
          drive.setCapacity(capacity);
          drive.setDriveType(driveType);
          drive.setVirtualMachineId(virtualMachineId);
          return true;
        } else {
          return false;
        }
      } else {
        drive.setCapacity(capacity);
        drive.setDriveType(driveType);
        drive.setVirtualMachineId(virtualMachineId);
        return true;
      }
    }
    return false;
  }


  public VirtualMachineCategory getCategoryByName(String name) {
    for (VirtualMachineCategory virtualMachineCategory : this.virtualMachineCategories) {
      if (virtualMachineCategory.getName().equals(name)) {
        return virtualMachineCategory;
      }
    }
    return null;
  }

  public boolean addCategory(VirtualMachineCategory virtualMachineCategory) {
    boolean success = false;

    if (checkIfNameAvailable(virtualMachineCategory.getName(), "vmc")) {
      this.virtualMachineCategories.add(virtualMachineCategory);
      success = true;
    } 
    
    if (success) {
      fileManager.writeVirtualMachineCategoriesToFile(this.virtualMachineCategories);
    }

    return success;
  }

  public boolean deleteCategory(String name) {
    boolean success = false;

    for (VirtualMachineCategory virtualMachineCategory : this.virtualMachineCategories) {
      if (virtualMachineCategory.getName().equals(name)) {
        this.virtualMachineCategories.remove(virtualMachineCategory);
        success = true;
        break;
      }
    }
    
    if (success) {
      fileManager.writeVirtualMachineCategoriesToFile(this.virtualMachineCategories);
    }

    return success;
  }

  public boolean updateCategory(String oldName, String newName, int cores, int ram, int gpuCores) {
    boolean success = false;

    for (VirtualMachineCategory virtualMachineCategory : this.virtualMachineCategories) {
      if (virtualMachineCategory.getName().equals(oldName) && !oldName.equals(newName)) {
        if (checkIfNameAvailable(newName, "vmc")) {
          virtualMachineCategory.setName(newName);
          virtualMachineCategory.setNumberOfCores(cores);
          virtualMachineCategory.setGbsOfRam(ram);
          virtualMachineCategory.setGpuCores(gpuCores);
          success = false;
        } else {
          success = false;
        }
      } else {
        virtualMachineCategory.setNumberOfCores(cores);
        virtualMachineCategory.setGbsOfRam(ram);
        virtualMachineCategory.setGpuCores(gpuCores);
        success = true;
      }
    }


    if (success) {
      fileManager.writeVirtualMachineCategoriesToFile(this.virtualMachineCategories);
    }

    return success;
  }



}