package com.mallstore.domain.dao;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.order.Order;

import java.util.List;

/**
 * Created by DeKi on 8/25/2016.
 */
public interface OrderRepository {

  Order getOrderById(EntityId entityId);
  List<Order> getAllOrdersByCustomerId(EntityId customerId);
}
