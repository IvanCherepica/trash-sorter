package com.trash_sorter.dao;



import com.trash_sorter.model.Category;

import java.util.List;


public interface CategoryDAO {
    boolean addNewCategory(Category cat);
    boolean deleteCategory(Category cat);
    Category getCategoryById(long id);
    List<String> getCategoriesName();
    List<Category> getAllCategories();
}
