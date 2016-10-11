package com.mallstore.ui.category;

import com.mallstore.domain.model.product.Product;
import com.mallstore.domain.model.product.category.Category;
import com.mallstore.domain.product.ProductService;
import com.mallstore.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by DeKi on 10/11/2016.
 */
@Controller
public class CategoryController {

    @Autowired
    private ProductService productService;
    @Autowired private CategoryService categoryService;

    @RequestMapping(
            path = "category/{categoryType}/{page}/{size}",
            method = RequestMethod.GET)
    public String getCategory(Model model,
                              @PathVariable String categoryType,
                              @PathVariable Integer page,
                              @PathVariable Integer size) {
        page = setDefaultPageNumberIfNotSet(page);
        size = setDefaultPageElementsIfNotSet(size);
        Category category = categoryService.getCategoryByName(categoryType);
        List<Product> products = productService.
                paginationProductsByCategory(category, page, size);
        model.addAttribute("products", products);
        model.addAttribute("pagination", productService.createPagination(category, size));
        model.addAttribute("size", size);
        model.addAttribute("category", categoryType);
        model.addAttribute("currentPagination", page);
        model.addAttribute("categories", categoryService.getBaseCategories());
        return "shop";
    }

    private Integer setDefaultPageNumberIfNotSet(Integer page) {
        if(page == null) {
            page = 0;
        }
        return page;
    }

    private Integer setDefaultPageElementsIfNotSet(Integer elementsPerPage) {
        if(elementsPerPage == null) {
            elementsPerPage = 20;
        }
        return elementsPerPage;
    }
}
