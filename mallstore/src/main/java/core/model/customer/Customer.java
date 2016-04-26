package core.model.customer;

import core.model.EntityId;

import java.util.Collections;
import java.util.List;

/**
 * Created by DeKi on 1/31/2016.
 */
//Entity
public class Customer {

    private EntityId entityId;
    private Name name;
    private Address address;
    private String phone;
    private String email;
    private Credential credential;
    private List<EntityId> orderEntityIds;

    public Customer(CustomerBuilder customerBuilder) {
        this.entityId = customerBuilder.getEntityId();
        this.name = customerBuilder.getName();
        this.address = customerBuilder.getAddress();
        this.phone = customerBuilder.getPhone();
        this.email = customerBuilder.getEmail();
        this.credential = customerBuilder.getCredential();
        this.orderEntityIds = customerBuilder.getOrderEntityIds();
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public List<EntityId> getOrderEntityIds() {
        return Collections.unmodifiableList(orderEntityIds);
    }

    public void setOrder(EntityId entityId) {
        orderEntityIds.add(entityId);
    }

    public boolean hasOrders() {
        boolean result = false;
        if(orderEntityIds != null && orderEntityIds.size() > 0) {
            result = true;
        }
        return result;
    }

    public EntityId getOrderById(EntityId entityId) {
        EntityId foundOrderEntityId = null;
        if(!hasOrders()) {
            return foundOrderEntityId;
        }
        for(EntityId orderEntityId : orderEntityIds) {
            if(entityId.equals(orderEntityId)) {
                foundOrderEntityId = orderEntityId;
                break;
            }
        }
        return foundOrderEntityId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append(entityId.toString());
        sb.append(name.toString());
        sb.append(address.toString());
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(credential.toString());
        return sb.toString();
    }
}
