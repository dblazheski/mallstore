package com.mallstore.domain.model.product.category;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by DeKi on 4/16/2016.
 */
public class CategoryTest {

    private Category category;
    private Category comedyMoviesCategory;
    private Category tarjaCategory;

    @Before
    public void setUp() {
        this.category = new Category("root", null);
        Category booksCategory = new Category("books", category);
        Category moviesCategory = new Category("movies", category);
        Category horrorMoviesCategory = new Category("Horror Movies", moviesCategory);
        this.comedyMoviesCategory = new Category("Comedy", moviesCategory);
        Category charlieCategory = new Category("Charlie", comedyMoviesCategory);
        this.tarjaCategory = new Category("Tarja", comedyMoviesCategory);
        comedyMoviesCategory.addSubCategory(tarjaCategory);
        comedyMoviesCategory.addSubCategory(charlieCategory);
        moviesCategory.addSubCategory(comedyMoviesCategory);
        moviesCategory.addSubCategory(horrorMoviesCategory);
        category.addSubCategory(booksCategory);
        category.addSubCategory(moviesCategory);
    }

    @Test
    public void getPathList() {
        tarjaCategory.getParentCategory();
        for(String path : tarjaCategory.getPathList()){
            System.out.println(path);
        }
    }
}