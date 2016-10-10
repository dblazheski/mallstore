package com.mallstore.domain.model.customer;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.Embeddable;

/**
 * Created by DeKi on 2/2/2016.
 */
//Value Object
@Embeddable
public class Credential {

  private String username;
  private String password;

  public Credential(final String username, final String password) {
    Validate.notNull(username, "Username not specified");
    Validate.notNull(password, "Password not specified");
    this.username = username;
    this.password = password;
  }

  public Credential changePassword(final String password) {
    return new Credential(this.username, password);
  }

  public Credential changeUsername(final String username) {
    return new Credential(username, this.password);
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (o == null || getClass() != o.getClass()) return false;

    Credential that = (Credential) o;

    return new EqualsBuilder()
        .append(username, that.username)
        .append(password, that.password)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(username)
        .append(password)
        .toHashCode();
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Credential{");
    sb.append("username='").append(username).append('\'');
    sb.append('}');
    return sb.toString();
  }

  protected Credential() {}
}
