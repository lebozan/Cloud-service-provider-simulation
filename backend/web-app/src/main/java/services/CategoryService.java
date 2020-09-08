package services;

import java.util.ArrayList;

import Utility.DataCollectionManager;
import classModels.VirtualMachineCategory;

public class CategoryService {
  private DataCollectionManager collectionManager;

  public CategoryService() {

  }

  public CategoryService(DataCollectionManager collectionManager) {

    this.collectionManager = collectionManager;
  }

  public DataCollectionManager getCollectionManager() {

    return this.collectionManager;
  }

  public void setCollectionManager(DataCollectionManager collectionManager) {
    this.collectionManager = collectionManager;
  }

  public ArrayList<VirtualMachineCategory> getAllCategories() {
    return collectionManager.getVirtualMachineCategories();
  }

  public VirtualMachineCategory getCategoryByName(String name) {

    return collectionManager.getCategoryByName(name);
  }

  public boolean addCategory(VirtualMachineCategory virtualMachineCategory) {
    return collectionManager.addCategory(virtualMachineCategory);
  }

  public boolean deleteCategory(String name) {

    return collectionManager.deleteCategory(name);
  }

  public boolean updateCategory(String oldName, String newName, int cores, int ram, int gpuCores) {

    return collectionManager.updateCategory(oldName, newName, cores, ram, gpuCores);
  }


}