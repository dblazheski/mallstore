package com.mallstore.domain.model.customer.address;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Embeddable;

/**
 * Created by DeKi on 8/3/2016.
 */
@Embeddable
public class Street {

  private String street;
  private String number;
  private Integer zip;

  public Street(final String street, final String number, final Integer zip) {
    this.street = street;
    this.number = number;
    this.zip = zip;
  }

  public Street changeZipNumber(final Integer zip) {
    return new Street(this.street, this.number, zip);
  }

  public Street changeStreet(final String street) {
    return new Street(street, this.number, this.zip);
  }

  public Street changeStreetNumber(final String number) {
    return new Street(this.street, number, this.zip);
  }

  public String getStreet() {
    return street;
  }

  public String getNumber() {
    return number;
  }

  public Integer getZip() {
    return zip;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Street street1 = (Street) o;

    return new EqualsBuilder()
        .append(street, street1.street)
        .append(number, street1.number)
        .append(zip, street1.zip)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(street)
        .append(number)
        .append(zip)
        .toHashCode();
  }

  protected Street() {}
}
