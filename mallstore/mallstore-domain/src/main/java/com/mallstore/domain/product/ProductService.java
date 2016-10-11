package com.mallstore.domain.product;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.product.Product;
import com.mallstore.domain.model.product.category.Category;

import java.util.List;

/**
 * Created by DeKi on 10/11/2016.
 */
public interface ProductService {

    List<Product> getAllProductsByCategory(Category categoryType);
    List<Product> paginationProductsByCategory(Category categoryType, int pageNumber, int pageSize);
    Product getProductById(EntityId id);
    Long getNumberOfProductsByCategory(Category category);
    List<Long> createPagination(Category category, int pageSize);
}
