package com.mallstore.ui.shoppingcart;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.product.Product;
import com.mallstore.domain.model.product.Quantity;
import com.mallstore.domain.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/cart")
public class ShoppingCartController {

    @Autowired private ProductService productService;
    @Autowired private ShoppingCartManager shoppingCartManager;

    @RequestMapping(path = "/add/{id}/{qty}")
    public String addToCart(HttpSession session, @PathVariable String id, @PathVariable Integer qty) {
        addItemToCart(session, new EntityId(id), new Quantity(qty));
        return "redirect:/cart";
    }

    private void addItemToCart(HttpSession session,EntityId id, Quantity qty) {
        ShoppingCart cart = shoppingCartManager.getCartFromSession(session);
        Product product = productService.getProductById(id);
        CartItem item = null;
        if(product.hasEnoughQty(qty)) {
            item = new CartItem(product, qty);
            cart.addToCart(item);
        }
    }

    private void removeItemFromCart(HttpSession session, EntityId id) {
        ShoppingCart cart = shoppingCartManager.getCartFromSession(session);
        cart.removeItemFromCart(id);
    }

    @RequestMapping(path = "/add/{id}")
    public String addToCartWithoutQtySet(HttpSession session, @PathVariable String id) {
        addItemToCart(session, new EntityId(id), new Quantity(1));
        return "redirect:/cart";
    }

    @RequestMapping
    public String getShoppingCart(Model model, HttpSession session) {
        model.addAttribute("shoppingCart", shoppingCartManager.getCartFromSession(session));
        return "cart";
    }

    @RequestMapping(path = "/remove/{id}")
    public String removeItemFromCart(Model model, HttpSession session, @PathVariable String id) {
        removeItemFromCart(session, new EntityId(id));
        return "redirect:/cart";
    }

}
