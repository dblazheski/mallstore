package com.mallstore.domain.service.impl;

import com.mallstore.domain.dao.OrderRepository;
import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.order.Order;
import com.mallstore.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DeKi on 8/25/2016.
 */
@Service
public class DefaultOrderService implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrderById(EntityId id) {
        return orderRepository.getOrderById(id);
    }

    public List<Order> getAllOrdersFromLogin(String username) {
        return null;
    }
}
