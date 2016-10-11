package com.mallstore.domain.service;

import com.mallstore.domain.model.product.category.Category;

import java.util.List;

/**
 * Created by DeKi on 10/11/2016.
 */
public interface CategoryService {

    void createNewCategory(Category category);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    List<Category> getBaseCategories();
}
