package core.model.order;

import core.model.EntityId;
import core.model.customer.Customer;

import java.util.Date;
import java.util.Set;

/**
 * Created by DeKi on 1/31/2016.
 */
//Entity
public class Order {

    private EntityId entityId;
    private String customerId;
    private Customer customer;
    private Set<OrderItem> orderedItems;
    private Date dateOfOrder;
    private Long totalCost;
}
