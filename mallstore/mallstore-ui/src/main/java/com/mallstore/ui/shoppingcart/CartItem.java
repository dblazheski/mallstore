package com.mallstore.ui.shoppingcart;

import com.mallstore.domain.model.product.Price;
import com.mallstore.domain.model.product.Product;
import com.mallstore.domain.model.product.Quantity;

public class CartItem {

    private Product product;
    private Quantity quantity;
    private Price price;

    public CartItem(Product product, Quantity quantity) {
        this.product = product;
        this.quantity = quantity;
        calculatePrice();
    }

    private void calculatePrice() {
       this.price = product.getCost().multiplyBy(quantity);
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
        calculatePrice();

    }

    public Price getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartItem cartItem = (CartItem) o;

        return product != null ? product.equals(cartItem.product) : cartItem.product == null;

    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
