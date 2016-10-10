package com.mallstore.domain.model.product.category;

import java.util.List;

/**
 * Created by DeKi on 4/24/2016.
 */
public abstract class BaseCategory {

    protected BaseCategory parent;
    protected String name;

    public void addSubCategory(BaseCategory category) {
        throw new UnsupportedOperationException();
    }

    public void removeSubCategory(BaseCategory category) {
        throw new UnsupportedOperationException();
    }

    public List<BaseCategory> getPath() {
        throw new UnsupportedOperationException();
    }
}
