package com.mallstore.persistence.manager.hibernate.action;

import org.hibernate.Session;

/**
 * Created by DeKi on 8/22/2016.
 */
public class DeleteOperation extends Operation {

  public DeleteOperation(Session session) {
    super(session);
  }

  @Override
  public void executeAction(Object object) {
    session.delete(object);
  }
}
