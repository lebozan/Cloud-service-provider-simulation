package services;

import Utility.DataCollectionManager;
import spark.Session;

public class SessionService {

  private DataCollectionManager collectionManager;

  public SessionService() {

  }

  public SessionService(DataCollectionManager collectionManager) {

    this.collectionManager = collectionManager;
  }

  public DataCollectionManager getCollectionManager() {

    return this.collectionManager;
  }

  public void setCollectionManager(DataCollectionManager collectionManager) {
    this.collectionManager = collectionManager;
  }

  public boolean hasSession(String sessionId) {

    return collectionManager.hasSession(sessionId);
  }

  public boolean addSession(Session session) {

    return collectionManager.addSession(session);
  }

  public boolean removeSession(String sessionId) {

    return collectionManager.removeSession(sessionId);
  }


  
}