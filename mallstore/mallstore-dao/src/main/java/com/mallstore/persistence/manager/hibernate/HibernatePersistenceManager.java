package com.mallstore.persistence.manager.hibernate;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.PersistableObject;
import com.mallstore.persistence.manager.PersistenceManager;
import com.mallstore.persistence.manager.hibernate.action.DeleteOperation;
import com.mallstore.persistence.manager.hibernate.action.SaveOperation;
import org.apache.commons.lang.StringUtils;
import org.hibernate.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by DeKi on 1/16/2016.
 */
@Component
public class HibernatePersistenceManager implements PersistenceManager {

  private static final Logger LOG = LoggerFactory.getLogger(HibernatePersistenceManager.class);
  @Autowired
  private SessionFactory sessionFactory;

  public <T extends PersistableObject> void deleteById(Class<T> entityClass, EntityId id) {
    Transaction transaction = null;
    Session session = sessionFactory.openSession();
    try {
      transaction = session.beginTransaction();
      T entity = session.load(entityClass, id);
      if(entity != null) {
        session.delete(entity);
      }
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null) {
        transaction.rollback();
        LOG.debug("Rolling back transaction ");
      }
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  public <T extends PersistableObject> void create(T entity) {
    new SaveOperation(sessionFactory.openSession()).execute(entity);
  }

  public <T extends PersistableObject> void update(T entity) {
    new SaveOperation(sessionFactory.openSession()).execute(entity);
  }

  public <T extends PersistableObject> void delete(T entity) {
    new DeleteOperation(sessionFactory.openSession()).execute(entity);
  }

  public <T> T getById(Class<T> entity, EntityId id) {
    Session session = sessionFactory.openSession();
    return session.get(entity,id);
  }

  public List executeQuery(String query) {
    Session session = sessionFactory.openSession();
    return session.createQuery(query).list();
  }

  public List executeQueryWithParams(String query, Map<String, Object> params) {
    Session session = sessionFactory.openSession();
    Query qry = session.createQuery(query);
    if (params != null) {
      for (Map.Entry<String, Object> param : params.entrySet()) {
        qry.setParameter(param.getKey(), param.getValue());
      }
    }
    return qry.list();
  }

  public List getQueryPaginationResults(String query, Map<String, Object> queryParams, int pageNumber, int pageSize) {
    Session session = sessionFactory.openSession();
    Query qry = session.createQuery(query);
    if (queryParams != null) {
      for (Map.Entry<String, Object> param : queryParams.entrySet()) {
        qry.setParameter(param.getKey(), param.getValue());
      }
    }
    qry.setFirstResult((pageNumber - 1) * pageSize);
    qry.setMaxResults(pageSize);
    return qry.list();
  }

  @SuppressWarnings("unchecked")
  public <T extends PersistableObject> List<T> getAll(Class<T> entity) {
    String tableName = getTableName(entity);
    Session session = sessionFactory.openSession();
    Query qry = session.createQuery("FROM " + tableName);
    return qry.list();
  }

  public Object getUniqueResult(String query, Map<String, Object> params) {
    Session session = sessionFactory.openSession();
    Query qry = session.createQuery(query);
    if (params != null) {
      for (Map.Entry<String, Object> param : params.entrySet()) {
        qry.setParameter(param.getKey(), param.getValue());
      }
    }
    return qry.uniqueResult();
  }

  private String getTableName(Class<? extends PersistableObject> entity) {
    String tableName;
    Entity entityAnnotation = entity.getAnnotation(Entity.class);
    Table tableAnnotation = entity.getAnnotation(Table.class);
    if (entityAnnotation != null && StringUtils.isNotBlank(entityAnnotation.name())) {
      return entityAnnotation.name().toLowerCase();
    }
    if (tableAnnotation != null && StringUtils.isNotBlank(tableAnnotation.name())) {
      return tableAnnotation.name().toLowerCase();
    }
    tableName = entity.getSimpleName().toLowerCase();
    return tableName;
  }

  private EntityId nextUUID() {
    UUID uuid = UUID.randomUUID();
    EntityId id = new EntityId(uuid.toString());
    return id;
  }


//    public PersistableObject searchById(Category entityObject) {
//        Transaction transaction = null;
//        SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        return (PersistableObject) session.get(entityObject.getClassType(), entityObject.getEntityId());
//    }
}