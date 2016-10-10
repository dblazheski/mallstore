package com.mallstore.domain.dao;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.customer.Customer;

import java.util.List;

/**
 * Created by DeKi on 8/4/2016.
 */
public interface CustomerRepository {

  List<Customer> getAllUsers();
  Customer getCustomerByLogin(String login);
  Customer getCustomerById(EntityId id);
  void storeCustomer(Customer customer);
  void deleteCustomer(EntityId id);
}
