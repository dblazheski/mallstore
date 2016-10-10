package com.mallstore.domain.model.customer;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by DeKi on 2/2/2016.
 */
//Value Object
@Embeddable
public class Name {

  @Column(name = "firstName")
  private String firstName;
  //private String middleName;
  @Column(name = "lastName")
  private String lastName;

  public Name(final String firstName, final String lastName) {
    Validate.notNull(firstName, "First Name is required");
    Validate.notNull(lastName, "Last Name is required");
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Name name = (Name) o;

    return new EqualsBuilder()
        .append(firstName, name.firstName)
        .append(lastName, name.lastName)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(firstName)
        .append(lastName)
        .toHashCode();
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Name{");
    sb.append("firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append('}');
    return sb.toString();
  }

  protected Name() {
  }
}
