package com.mallstore.domain.model.product;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Embeddable;

/**
 * Created by DeKi on 4/2/2016.
 */
@Embeddable
public class Price {

  private Float price;

  public Price(Float price) {
    validatePrice(price);
    this.price = price;
  }

  public Float getPrice() {
    return price;
  }

  public Price add(Float price) {
    validatePrice(price);
    return new Price(this.price + price);
  }

  public Price minus(Float price) {
    validatePrice(price);
    if ((this.price - price) < 0) {
      throw new IllegalArgumentException("The given price cannot be greater than current price");
    }
    return new Price(this.price - price);
  }

  public Price multiplyBy(Quantity quantity) {
    Integer quantityValue = 1;
    if (!quantity.getQuantity().equals(0)) {
      quantityValue = quantity.getQuantity();
    }
    return new Price(this.price * quantityValue);
  }

  private void validatePrice(Float price) {
    Validate.notNull(price, "Price cannot be null");
    if (price < 0) {
      throw new IllegalArgumentException("Price cannot be negative");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Price price1 = (Price) o;

    return new EqualsBuilder()
        .append(price, price1.price)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(price)
        .toHashCode();
  }

  protected Price() {
  }
}
