package services;

import java.util.ArrayList;

import Utility.DataCollectionManager;
import classModels.VirtualMachine;
import classModels.VirtualMachineCategory;

public class VirtualMachineService {
  private DataCollectionManager collectionManager;

  public VirtualMachineService() {

  }

  public VirtualMachineService(DataCollectionManager collectionManager) {
    this.collectionManager = collectionManager;
  }

  public DataCollectionManager getCollectionManager() {

      return this.collectionManager;
  }

  public void setCollectionManager(DataCollectionManager collectionManager) {
    this.collectionManager = collectionManager;
  }

  public ArrayList<VirtualMachine> getVirtualMachines() {

      return collectionManager.getVirtualMachines();
  }

  public VirtualMachine getVmById(int id) {

      return collectionManager.getVmById(id);
  }

  public VirtualMachine getVmByName(String name) {

      return collectionManager.getVmByName(name);
  }

  public boolean addVirtualMachine(VirtualMachine virtualMachine, int organizationId) {

      return collectionManager.addVirtualMachine(virtualMachine, organizationId);
  }

  public boolean deleteVirtualMachine(String name) {

      return collectionManager.deleteVirtualMachine(name);
  }

  public boolean updateVirtualMachine(String oldName, String newName, VirtualMachineCategory newCategory, int organizationId) {

      return collectionManager.updateVirtualMachine(oldName, newName, newCategory, organizationId);
  }

}