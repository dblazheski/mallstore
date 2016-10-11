package com.mallstore.domain.product;

import com.mallstore.domain.dao.ProductRepository;
import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.product.Product;
import com.mallstore.domain.model.product.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DeKi on 10/11/2016.
 */
@Service
public class DefaultProductService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProductsByCategory(Category categoryType) {
        return productRepository.getProductsByCategory(categoryType);
    }

    public List<Product> paginationProductsByCategory(Category categoryType, int pageNumber, int pageSize) {
        return productRepository.paginationProductsByCategory(categoryType,pageNumber,pageSize);
    }

    public Product getProductById(EntityId id) {
        return productRepository.getProductById(id);
    }

    public Long getNumberOfProductsByCategory(Category category) {
        return productRepository.getNumberOfProductsByCategory(category);
    }

    public List<Long> createPagination(Category category, int pageSize) {
        List<Long> pagination = new ArrayList<Long>();
        Long totalProducts = getNumberOfProductsByCategory(category);
        Long pageNumbers = totalProducts / pageSize;
        for(Long i = 1L; i <= pageNumbers; i++) {
            pagination.add(i);
        }
        return pagination;
    }
}
