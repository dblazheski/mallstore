package com.mallstore.ui.shoppingcart;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.product.Price;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {

    private final List<CartItem> cartItems = new ArrayList<CartItem>();
    private Price total;

    public ShoppingCart() {

    }

    public void removeItemFromCart(EntityId id) {
        for(CartItem item : cartItems) {
            if(item.getProduct().getId().equals(id)) {
                cartItems.remove(item);
                break;
            }
        }
        calculateTotal();
    }

    public void addToCart(CartItem cartItem) {
        if(itemExist(cartItem)) {
            CartItem existingItem = getItem(cartItem);
            existingItem.setQuantity(cartItem.getQuantity());
        } else {
            cartItems.add(cartItem);
        }
        calculateTotal();
    }

    private void calculateTotal() {
        total = new Price(0.0F);
        for(CartItem cartItem : cartItems) {
            total = total.add(cartItem.getPrice().getPrice());
        }
    }

    public void removeFromCart(CartItem cartItem) {
        cartItems.remove(cartItem);
        calculateTotal();
    }

    private CartItem getItem(CartItem cartItem) {
        CartItem existingItem = null;
        for(CartItem item : cartItems) {
            if(item.equals(cartItem)) {
                existingItem = item;
                break;
            }
        }
        return existingItem;
    }

    private boolean itemExist(CartItem cartItem) {
        boolean result = false;
        for(CartItem existingItem : cartItems) {
            if(existingItem.equals(cartItem)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public List<CartItem> getCartItems() {
        return Collections.unmodifiableList(cartItems);
    }

    public Price getTotal() {
        return total;
    }
}
