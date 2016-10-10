package com.mallstore.domain.model.product.category;

/**
 * Created by DeKi on 4/23/2016.
 */
public class CategoryOld2 extends BaseCategory {

    //    private JSONArray iterateOverCategory(List<Category> subCategories, JSONObject jsonObject) {
//        JSONArray categories = new JSONArray();
//        JSONObject subcategory = new JSONObject();
//        for (Category subCategory : subCategories) {
//            if (subCategory.hasSubCategories()) {
//                JSONArray category = null; //iterateOverCategory(subCategory.getSubCategories(), jsonObject);
//                subcategory.put(subCategory.getName(), category);
//            }
//            if (subcategory.has(subCategory.getName())) {
//                categories.put(subcategory);
//            } else {
//                categories.put(subCategory.getName());
//            }
//        }
//        jsonObject.put(MENU, categories);
//        return categories;
//    }


//    public Category getCategoryByName(String category) {
//        Validate.notNull(category, "CategoryName cannot be null");
//        Category foundCategory = null;
//        Category rootCategory = getRootCategory();
//        for()
//        if(rootCategory.getName().equals(category))
//            foundCategory = rootCategory;
//    }

//    public String iterateAllCategories() {
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put(MENU, new JSONArray());
//        //iterateOverCategory(getBaseCategories(), jsonObject);
//        return jsonObject.toString();
//    }
}
