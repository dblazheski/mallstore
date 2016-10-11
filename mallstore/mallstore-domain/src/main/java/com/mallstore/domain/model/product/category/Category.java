package com.mallstore.domain.model.product.category;

import com.mallstore.domain.model.EntityId;
import com.mallstore.domain.model.PersistableObject;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.*;

/**
 * Created by DeKi on 4/16/2016.
 */
@Entity(name = "category")
public class Category implements PersistableObject {

    @Id @EmbeddedId
    private EntityId id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private Category parentCategory;
    @OneToMany(mappedBy = "parentCategory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Category> subCategories;
    private static final String ROOT = "root";

    public Category(String name, Category parentCategory) {
        Validate.notNull(name, "Name cannot be blank");
        this.name = name;
        this.parentCategory = parentCategory;
        this.subCategories = new HashSet<Category>();
    }

    public List<String> getPathList() {
        LinkedList<String> path = new LinkedList<String>();
        Category currentCategory = this;
        while(currentCategory != null) {
            String categoryName = currentCategory.getName();
            currentCategory = currentCategory.getParentCategory();
            if(ROOT.equalsIgnoreCase(categoryName)){
                continue;
            }
            path.addFirst(categoryName);
        }
        return Collections.unmodifiableList(path);
    }

    public Set<Category> getBaseCategories() {
        if (this.isParentCategory()) {
            return this.getSubCategories();
        }
        return parentCategory.getBaseCategories();
    }

    public boolean hasSubCategories() {
        return getSubCategories().size() > 0;
    }

    public Set<Category> getSubCategories() {
        return Collections.unmodifiableSet(subCategories);
    }

    private boolean isParentCategory() {
        return parentCategory == null;
    }

    public String getName() {
        return name;
    }

    protected Category getParentCategory() {
        return parentCategory;
    }

    public void addSubCategory(Category subCategory) {
        Validate.notNull(subCategory, "SubCategory cannot be null");
        if (subCategories.contains(subCategory)) {
            throw new IllegalArgumentException("SubCategory exist");
        }
        subCategories.add(subCategory);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return new EqualsBuilder()
                .append(name, category.name)
                .append(parentCategory, category.parentCategory)
                .append(subCategories, category.subCategories)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(name)
//                .append(parentCategory)
//                .append(subCategories)
                .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Category{");
        sb.append("name='").append(name).append('\'');
        sb.append(", subCategories=").append(subCategories);
        sb.append(", entityId=").append(id);
        sb.append('}');
        return sb.toString();
    }

    protected Category() {}

    public EntityId getId() {
        return id;
    }
}
