package com.mallstore.persistence.dao.order;

import com.mallstore.domain.dao.OrderRepository;
import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.order.Order;
import com.mallstore.persistence.manager.PersistenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by DeKi on 8/25/2016.
 */
@Repository
public class DefaultOrderRepository implements OrderRepository {

  @Autowired
  PersistenceManager persistenceManager;

  public Order getOrderById(EntityId entityId) {
    return persistenceManager.getById(Order.class, entityId);
  }
}
