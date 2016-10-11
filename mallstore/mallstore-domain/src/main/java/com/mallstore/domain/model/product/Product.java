package com.mallstore.domain.model.product;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.PersistableObject;
import com.mallstore.domain.model.product.category.Category;

import javax.persistence.*;

/**
 * Created by DeKi on 1/31/2016.
 */
@Entity
public class Product implements PersistableObject {

  @Id
  @Embedded
  private EntityId entityId;

  @JoinColumn(name = "categoryId")
  @ManyToOne
  private Category category;
  private String name;
  private String manufacturer;
  @Column(columnDefinition = "TEXT")
  private String description;
  private Quantity qty;
  private Price cost;

  public Price calculatePrice() {
    return cost.multiplyBy(qty);
  }

  public EntityId getId() {
    return this.entityId;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Quantity getQty() {
    return qty;
  }

  public void setQty(Quantity qty) {
    this.qty = qty;
  }

  public Price getCost() {
    return cost;
  }

  public void setCost(Price cost) {
    this.cost = cost;
  }
}
