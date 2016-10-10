package com.mallstore.domain.model.product;

import com.mallstore.domain.model.EntityId;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by DeKi on 1/31/2016.
 */
@Entity
public class Product {

  @Id
  @Embedded
  private EntityId entityId;
  private String name;
  private String manufacturer;
  private String imagePath;
  @Column(columnDefinition = "TEXT")
  private String description;
  private Quantity qty;
  private Price cost;

  public Price calculatePrice() {
    return cost.multiplyBy(qty);
  }
}
