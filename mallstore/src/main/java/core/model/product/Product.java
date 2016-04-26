package core.model.product;

import core.model.EntityId;

/**
 * Created by DeKi on 1/31/2016.
 */
public class Product {

    private EntityId entityId;
    private String name;
    private String manufacturer;
    private Quantity qty;
    private Price cost;

    public Price calculatePrice() {
        return cost.multiplyBy(qty);
    }
}
