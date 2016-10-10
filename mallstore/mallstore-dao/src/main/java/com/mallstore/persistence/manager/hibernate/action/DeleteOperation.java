package com.mallstore.persistence.manager.hibernate.action;

/**
 * Created by DeKi on 8/22/2016.
 */
public class DeleteOperation extends Operation {

  @Override
  public void executeAction(Object object) {
    session.delete(object);
  }
}
