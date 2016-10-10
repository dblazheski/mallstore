package com.mallstore.domain.model.order;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.PersistableObject;
import com.mallstore.domain.model.customer.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by DeKi on 1/31/2016.
 */
@Entity(name = "customerorder")
public class Order implements PersistableObject {

  @Id @Embedded
  private EntityId entityId;

  @JoinColumn(name = "customerId")
  @ManyToOne
  private Customer customer;

  private Date dateOfOrder;
  private Long totalCost;
  @Enumerated(EnumType.ORDINAL)
  private OrderStatus status;
  @OneToMany
  @JoinTable(
      name="ORDERED_ITEMS",
      joinColumns = @JoinColumn( name="customerorder_id"),
      inverseJoinColumns = @JoinColumn( name="orderitem_id")
  )
  private Set<OrderItem> orderItems;

  protected Order() {
  }

  public EntityId getId() {
    return entityId;
  }

  public Date getDateOfOrder() {
    return dateOfOrder;
  }

  public Long getTotalCost() {
    return totalCost;
  }
}
