package com.mallstore.ui.shoppingcart;


import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class ShoppingCartManager {

    public static final String CART = "cart";

    public synchronized ShoppingCart getCartFromSession(HttpSession session) {
        if(!shoppingCartExistInSession(session)) {
            addCartToSession(session);
        }
        return (ShoppingCart) session.getAttribute(CART);
    }

    private void addCartToSession(HttpSession session) {
        session.setAttribute(CART, new ShoppingCart());
    }

    private boolean shoppingCartExistInSession(HttpSession session) {
        ShoppingCart cart = (ShoppingCart) session.getAttribute(CART);
        return cart != null;
    }
}
