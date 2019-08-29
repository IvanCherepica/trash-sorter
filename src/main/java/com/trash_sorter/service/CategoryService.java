package com.trash_sorter.service;



import com.trash_sorter.model.Category;

import java.util.List;

public interface CategoryService {
    boolean addNewCategory(Category cat);
    boolean deleteCategory(Category cat);
    Category getCategoryById(long id);
    List<String> getCategoriesName();
    List<Category> getAllCategories();
}
