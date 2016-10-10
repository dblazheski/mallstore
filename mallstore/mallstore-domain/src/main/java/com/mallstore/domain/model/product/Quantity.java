package com.mallstore.domain.model.product;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Embeddable;

/**
 * Created by DeKi on 4/2/2016.
 */
@Embeddable
public class Quantity {

  private final Integer quantity;

  public Quantity(Integer quantity) {
    validateQuantity(quantity);
    this.quantity = quantity;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public Quantity add(Integer quantity) {
    validateQuantity(quantity);
    return new Quantity(this.quantity + quantity);
  }

  public Quantity minus(Integer quantity) {
    validateQuantity(quantity);
    if ((this.quantity - quantity) < 0) {
      throw new IllegalArgumentException("New quantity cannot be greater than current quantity");
    }
    return new Quantity(this.quantity - quantity);
  }

  private void validateQuantity(Integer quantity) {
    Validate.notNull(quantity, "Quantity cannot be null");
    if (quantity < 0) {
      throw new IllegalArgumentException("Quantity cannot be negative");
    }
  }

  public boolean hasQuantity() {
    return this.quantity > 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Quantity quantity1 = (Quantity) o;

    return new EqualsBuilder()
        .append(quantity, quantity1.quantity)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(quantity)
        .toHashCode();
  }
}
