package com.mallstore.domain.model.customer.address;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * Created by DeKi on 2/2/2016.
 */
//Value Object
@Embeddable
public class Address {

  @Embedded
  private Street street;
  private String city;
  private String country;

  public Address(final Street street, final String city, final String country) {
    Validate.notNull(street, "Street not specified.");
    Validate.notNull(city, "City not specified");
    Validate.notNull(country, "Country not specified");
    this.street = street;
    this.city = city;
    this.country = country;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  public Street getStreet() {
    return street;
  }

  public Address changeStreet(final Street street) {
    return new Address(street, this.city, this.country);
  }

  public Address changeCity(final String city) {
    return new Address(this.street, city, this.country);
  }

  public Address changeCountry(final String country) {
    return new Address(this.street, this.city, country);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Address address = (Address) o;

    return new EqualsBuilder()
        .append(street, address.street)
        .append(city, address.city)
        .append(country, address.country)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(street)
        .append(city)
        .append(country)
        .toHashCode();
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Address{");
    sb.append("street=").append(street.toString());
    sb.append(", city='").append(city).append('\'');
    sb.append(", country='").append(country).append('\'');
    sb.append('}');
    return sb.toString();
  }

  protected Address() {
  }
}