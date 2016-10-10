package com.mallstore.domain.model.order;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.PersistableObject;
import com.mallstore.domain.model.product.Price;
import com.mallstore.domain.model.product.Quantity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by DeKi on 2/2/2016.
 */
@Entity
public class OrderItem implements PersistableObject {

  @Id @Embedded
  private EntityId id;
  @Embedded
  private Price price;
  @Embedded
  private Quantity qty;

  public EntityId getId() {
    return this.id;
  }
}
