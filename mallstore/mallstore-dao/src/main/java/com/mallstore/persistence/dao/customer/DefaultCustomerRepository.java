package com.mallstore.persistence.dao.customer;

import com.mallstore.persistence.manager.PersistenceManager;
import com.mallstore.domain.dao.CustomerRepository;
import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by DeKi on 8/4/2016.
 */
@Repository
public class DefaultCustomerRepository implements CustomerRepository {

  private PersistenceManager persistenceManager;
  private final String QUERY = "FROM Customer";
  private final String GET_LOGIN = "FROM Customer WHERE username = :username";
  private final Class customer = Customer.class;

  @Autowired
  public DefaultCustomerRepository(PersistenceManager persistenceManager) {
    this.persistenceManager = persistenceManager;
  }

  public List<Customer> getAllUsers() {
    return persistenceManager.getAll(Customer.class);
    //return persistenceManager.executeQuery(QUERY);
  }

  public Customer getCustomerByLogin(String login) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("username", login);
    return (Customer) persistenceManager.getUniqueResult(GET_LOGIN, params);
  }

  public Customer getCustomerById(EntityId id) {
    return persistenceManager.getById(Customer.class, id);
  }

  public void storeCustomer(Customer customer) {
    persistenceManager.create(customer);
  }

  public void deleteCustomer(EntityId id) {
    persistenceManager.deleteById(Customer.class, id);
  }

  private String nextUUID() {
    return UUID.randomUUID().toString();
  }
}
