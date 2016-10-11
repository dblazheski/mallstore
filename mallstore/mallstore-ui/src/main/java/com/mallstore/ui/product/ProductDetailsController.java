package com.mallstore.ui.product;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.product.Product;
import com.mallstore.domain.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by DeKi on 10/11/2016.
 */
@Controller
@RequestMapping(path = "/product")
public class ProductDetailsController {

    @Autowired
    private ProductService productService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getProduct(Model model, @PathVariable String id) {
        Product product = productService.getProductById(new EntityId(id));
        return null;
    }
}
