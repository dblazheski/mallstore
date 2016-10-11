package com.mallstore.domain.dao;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.product.Product;
import com.mallstore.domain.model.product.category.Category;

import java.util.List;

/**
 * Created by DeKi on 10/11/2016.
 */
public interface ProductRepository {

    Product getProductById(EntityId id);
    List<Product> getProductsByCategory(Category category);
    List<Product> paginationProductsByCategory(Category category, int pageNumber, int pageSize);
    Long getNumberOfProductsByCategory(Category category);
    void addProduct(Product product);
    void removeProduct(EntityId id);
}
