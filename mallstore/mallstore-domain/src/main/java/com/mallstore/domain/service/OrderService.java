package com.mallstore.domain.service;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.order.Order;

import java.util.List;

/**
 * Created by DeKi on 8/25/2016.
 */
public interface OrderService {

  Order getOrderById(EntityId id);
  List<Order> getAllOrdersFromCustomer(EntityId customerId);
}
