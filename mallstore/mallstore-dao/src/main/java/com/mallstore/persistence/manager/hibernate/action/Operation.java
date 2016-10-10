package com.mallstore.persistence.manager.hibernate.action;

import com.mallstore.domain.model.PersistableObject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.PersistenceException;

/**
 * Created by DeKi on 1/16/2016.
 */
public abstract class Operation {

  private final static Logger logger = LoggerFactory.getLogger(Operation.class);
  SessionFactory sessionFactory;
  Session session;


  public <T extends PersistableObject> void execute(T object) throws PersistenceException {
    Transaction transaction = null;
    try {
      session = sessionFactory.openSession();
      transaction = session.beginTransaction();
      executeAction(object);
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null) {
        transaction.rollback();
        logger.error("Rolling back transaction", e);
      }
      throw new PersistenceException("Error while saving entity object");
    } finally {
      session.close();
    }
  }

  protected abstract void executeAction(Object object);

}
