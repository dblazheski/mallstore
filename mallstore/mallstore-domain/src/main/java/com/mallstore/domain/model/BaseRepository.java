package com.mallstore.domain.model;

import com.mallstore.domain.model.product.Price;
import com.mallstore.domain.model.product.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DeKi on 3/30/2016.
 */
public abstract class BaseRepository {

    public String generateId() {
        //return UUID.randomUUID().toString().toUpperCase();
        Price total = new Price(0.0f);
        List<Product> products = new ArrayList<Product>();
        for(Product product : products) {
            total = total.add(product.calculatePrice().getPrice());
        }
        return null;
    }
}
