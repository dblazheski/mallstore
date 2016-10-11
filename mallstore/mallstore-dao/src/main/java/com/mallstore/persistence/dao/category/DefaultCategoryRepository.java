package com.mallstore.persistence.dao.category;

import com.mallstore.domain.dao.CategoryRepository;
import com.mallstore.domain.model.EntityId;
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
public class DefaultCategoryRepository implements CategoryRepository {

    private static final String CATEGORY_BY_NAME = "FROM category WHERE name = :name";
    private static final String BASE_CATEGORIES = "FROM category WHERE parent_id IS NULL";

    @Autowired
    private PersistenceManager persistenceManager;

    public void createNewCategory(Category category) {
    }

    public Category getCategoryById(EntityId id) {
        return null;
    }

    public Category getCategoryByName(String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        return (Category) persistenceManager.getUniqueResult(CATEGORY_BY_NAME, params);
    }

    public List<Category> getAllCategories() {
        return persistenceManager.getAll(Category.class);
    }

    public List<Category> getRootCategories() {
        return persistenceManager.executeQuery(BASE_CATEGORIES);
    }
}
