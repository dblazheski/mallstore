package com.mallstore.persistence.dao.product;

import com.mallstore.domain.dao.ProductRepository;
import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.product.Product;
import com.mallstore.domain.model.product.category.Category;
import com.mallstore.persistence.manager.PersistenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DeKi on 10/11/2016.
 */
@Repository
public class DefaultProductRepository implements ProductRepository {

    private static final String PRODUCTS_BY_CATEGORY = "FROM Product WHERE categoryId = :category";
    private static final String COUNT_PRODUCTS_BY_CATEGORY = "SELECT count(*) FROM Product WHERE categoryid = :category";
    @Autowired
    private PersistenceManager persistenceManager;

    public Product getProductById(EntityId id) {
        return persistenceManager.getById(Product.class, id);
    }

    public List<Product> getProductsByCategory(Category category) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("category", category.getId().getId());
        return persistenceManager.executeQueryWithParams(PRODUCTS_BY_CATEGORY, params);
    }

    public List<Product> paginationProductsByCategory(Category category, int pageNumber, int pageSize) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("category", category.getId().getId());
        return persistenceManager.getQueryPaginationResults(PRODUCTS_BY_CATEGORY, params, pageNumber, pageSize);
    }

    public void addProduct(Product product) {
        persistenceManager.create(product);
    }

    public Long getNumberOfProductsByCategory(Category category) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("category", category.getId().getId());
        return (Long) persistenceManager.getUniqueResult(COUNT_PRODUCTS_BY_CATEGORY, params);
    }

    public void removeProduct(EntityId id) {
        persistenceManager.deleteById(Product.class, id);
    }
}
