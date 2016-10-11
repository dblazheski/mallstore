package com.mallstore.domain.service.impl;

import com.mallstore.domain.dao.CategoryRepository;
import com.mallstore.domain.model.product.category.Category;
import com.mallstore.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DeKi on 10/11/2016.
 */
@Service
public class DefaultCategoryService implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createNewCategory(Category category) {

    }

    public Category getCategoryByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    public List<Category> getBaseCategories() {
        return categoryRepository.getRootCategories();
    }
}
