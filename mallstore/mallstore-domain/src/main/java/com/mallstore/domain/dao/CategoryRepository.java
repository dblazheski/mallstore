package com.mallstore.domain.dao;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.product.category.Category;

import java.util.List;

/**
 * Created by DeKi on 10/11/2016.
 */
public interface CategoryRepository {

    void createNewCategory(Category category);
    Category getCategoryById(EntityId id);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    List<Category> getRootCategories();
}
