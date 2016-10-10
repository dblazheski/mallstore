package com.mallstore.domain.model.product.category;

import java.util.Deque;

/**
 * Created by DeKi on 4/24/2016.
 */
public abstract class BaseCat implements Cat {
    private Deque<CategoryOld2> categoryStack;

    protected void add(CategoryOld2 category) {

    }
    protected void iterate() {
        for(CategoryOld2 category : categoryStack){

        }
    }
}
