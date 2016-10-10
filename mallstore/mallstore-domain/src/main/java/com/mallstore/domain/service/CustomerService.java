package com.mallstore.domain.service;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.customer.Customer;

import java.util.List;

/**
 * Created by DeKi on 8/4/2016.
 */
public interface CustomerService {

  void registerNewCustomer(Customer customer);
  List<Customer> getAllRegisteredCustomers();
  void deleteCustomer(EntityId id);
  Customer getCustomerByLogin(String login);
  Customer getCustomerById(EntityId id);
}
