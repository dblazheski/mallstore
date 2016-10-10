package com.mallstore.domain.model.customer;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.PersistableObject;
import com.mallstore.domain.model.customer.address.Address;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

/**
 * Created by DeKi on 1/31/2016.
 */
@Entity
public class Customer implements PersistableObject {

  @Id
  @Embedded
  @Column(name = "customer_id")
  private EntityId entityId;
  @Embedded
  private Name name;
  @Embedded
  private Address address;
  private String phone;
  private String email;
  @Embedded
  private Credential credential;
  @ElementCollection
  @CollectionTable(name="customerorder", joinColumns=@JoinColumn(name="customerId"))
  private Set<EntityId> orderEntityIds;

  public Customer(CustomerBuilder customerBuilder) {
    this.entityId = customerBuilder.getEntityId();
    this.name = customerBuilder.getName();
    this.address = customerBuilder.getAddress();
    this.phone = customerBuilder.getPhone();
    this.email = customerBuilder.getEmail();
    this.credential = customerBuilder.getCredential();
    this.orderEntityIds = customerBuilder.getOrderEntityIds();
  }

  public void setName(Name name) {
    this.name = name;
  }

  public Name getName() {
    return this.name;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Address getAddress() {
    return this.address;
  }

  public void setCredential(Credential credential) {
    this.credential = credential;
  }

  public Credential getCredential() {
    return this.credential;
  }

  public Set<EntityId> getOrderIds() {
    return Collections.unmodifiableSet(orderEntityIds);
  }

  public void setOrder(EntityId entityId) {
    if(orderEntityIds.contains(entityId)) {
      throw new ElementExistException("Order with id: " + entityId.getId() + " already exist!");
    }
    orderEntityIds.add(entityId);
  }

  private boolean hasOrders() {
    boolean result = false;
    if (orderEntityIds != null && !orderEntityIds.isEmpty()) {
      result = true;
    }
    return result;
  }

  public EntityId getOrderById(EntityId entityId) {
    EntityId foundOrderEntityId = null;
    if (!hasOrders()) {
      return foundOrderEntityId;
    }
    for (EntityId orderEntityId : orderEntityIds) {
      if (entityId.equals(orderEntityId)) {
        foundOrderEntityId = orderEntityId;
        break;
      }
    }
    return foundOrderEntityId;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Customer{");
    sb.append(entityId.toString());
    sb.append(name.toString());
    sb.append(address.toString());
    sb.append(", phone='").append(phone).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append(credential.toString());
    return sb.toString();
  }

  public EntityId getId() {
    return this.entityId;
  }

  protected Customer() {

  }
}
