package com.mallstore.persistence.manager;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.PersistableObject;

import java.util.List;
import java.util.Map;

/**
 * Created by DeKi on 5/2/2016.
 */
public interface PersistenceManager {

  /**
   * Delete an entity from DB.
   *
   * @param entity - entity object that extends @{link PersistableObject}
   */
  <T extends PersistableObject> void delete(T entity);

  /**
   * Delete entity by Id from DB.
   *
   * @param entityClass Class type of entity object
   * @param id Id of the entity
   * @param <T>
   */
  <T extends PersistableObject> void deleteById(Class<T> entityClass, EntityId id);

  /**
   * Creates a new record into DB.
   *
   * @param entity Entity object that implements {@link PersistableObject}
   * @param <T>
   */
  <T extends PersistableObject> void create(T entity);

  /**
   * Updates existing record into DB.
   *
   * @param entity Entity object that implements {@link PersistableObject}
   * @param <T>
   */
  <T extends PersistableObject> void update(T entity);

  /**
   * Get record from DB by ID
   *
   * @param entity Entity class
   * @param id     Id of the entity.
   * @return Found record from DB
   */
  <T> T getById(Class<T> entity, EntityId id);

  /**
   * Gets all records from the DB.
   *
   * @param entity Class that implements {@link PersistableObject}
   * @param <T>
   * @return List of the Entity.
   */
  <T extends PersistableObject> List<T> getAll(Class<T> entity);

  /**
   * Executes the query to the DB.
   *
   * @param query SQL query.
   * @return
   */
  List executeQuery(String query);

  /**
   * Executes Hibernate Query to the DB.
   *
   * @param query Hibernate Query.
   * @param params Map of key-value parameters.
   * @return
   */
  Object getUniqeResult(String query, Map<String, Object> params);
}
