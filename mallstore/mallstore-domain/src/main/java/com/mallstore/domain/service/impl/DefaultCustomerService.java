package com.mallstore.domain.service.impl;

import com.mallstore.domain.dao.CustomerRepository;
import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.customer.Credential;
import com.mallstore.domain.model.customer.Customer;
import com.mallstore.domain.service.CustomerService;
import com.mallstore.domain.service.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DeKi on 8/4/2016.
 */
@Service
public class DefaultCustomerService implements CustomerService {

  private CustomerRepository customerRepository;

  @Autowired
  public DefaultCustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public void registerNewCustomer(Customer customer) {
    Credential credential = customer.getCredential();
    if (customerExist(credential)) {
      throw new UserExistException("User with login " + credential.getUsername() + " exist.");
    }
    customerRepository.storeCustomer(customer);
  }

  public List<Customer> getAllRegisteredCustomers() {
    return customerRepository.getAllUsers();
  }

  public void deleteCustomer(EntityId id) {
    customerRepository.deleteCustomer(id);
  }

  public Customer getCustomerByLogin(String login) {
    return customerRepository.getCustomerByLogin(login);
  }

  public Customer getCustomerById(EntityId id) {
    return customerRepository.getCustomerById(id);
  }

  private boolean customerExist(Credential credential) {
    boolean result = false;
    Customer existingCustomer = getCustomerByLogin(credential.getUsername());
    if (existingCustomer == null) {
      return result;
    }
    Credential existingCredential = existingCustomer.getCredential();
    if (credential.getUsername().equalsIgnoreCase(existingCredential.getUsername())) {
      result = true;
    }
    return result;
  }
}
