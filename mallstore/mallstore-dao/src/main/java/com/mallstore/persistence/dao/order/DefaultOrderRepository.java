package com.mallstore.persistence.dao.order;

import com.mallstore.domain.dao.OrderRepository;
import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.order.Order;
import com.mallstore.persistence.manager.PersistenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DeKi on 8/25/2016.
 */
@Repository
public class DefaultOrderRepository implements OrderRepository {
  private static final String ORDERS_BY_CUSTOMER = "FROM customerorder WHERE customerId = :customerId";

  @Autowired
  PersistenceManager persistenceManager;

  public Order getOrderById(EntityId entityId) {
    return persistenceManager.getById(Order.class, entityId);
  }

  public List<Order> getAllOrdersByCustomerId(EntityId customerId) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("customerId", customerId.getId());
    return persistenceManager.executeQueryWithParams(ORDERS_BY_CUSTOMER, params);
  }
}
