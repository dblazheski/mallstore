package com.mallstore.domain.model.customer;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.customer.address.Address;
import org.apache.commons.lang.Validate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DeKi on 3/28/2016.
 */
public class CustomerBuilder {

    private EntityId entityId;
    private Name name;
    private Address address;
    private String phone;
    private String email;
    private Credential credential;
    private Set<EntityId> orderEntityIds = new HashSet<EntityId>();

    public CustomerBuilder(EntityId entityId, Name name, Credential credential) {
        setEntityId(entityId);
        setName(name);
        setCredential(credential);
    }

    public CustomerBuilder setEntityId(EntityId entityId) {
        Validate.notNull(entityId, "EntityId not specified");
        this.entityId = entityId;
        return this;
    }

    public CustomerBuilder setName(Name name) {
        Validate.notNull(name, "Name not specified");
        this.name = name;
        return this;
    }

    public CustomerBuilder setAddress(Address address) {
        Validate.notNull(address, "Address not specified");
        this.address = address;
        return this;
    }

    public CustomerBuilder setPhone(String phone) {
        Validate.notNull(phone, "Phone not specified");
        this.phone = phone;
        return this;
    }

    public CustomerBuilder setEmail(String email) {
        Validate.notNull(email, "Email not specified");
        this.email = email;
        return this;
    }

    public CustomerBuilder setCredential(Credential credential) {
        Validate.notNull(credential, "Credential not specified");
        this.credential = credential;
        return this;
    }

    public CustomerBuilder setOrderds(Set<EntityId> orderEntityIds) {
        Validate.notNull(orderEntityIds, "Orders not specified");
        this.orderEntityIds = orderEntityIds;
        return this;
    }

    public Customer build() {
        return new Customer(this);
    }

    public EntityId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Credential getCredential() {
        return credential;
    }

    public Set<EntityId> getOrderEntityIds() {
        return orderEntityIds;
    }
}
