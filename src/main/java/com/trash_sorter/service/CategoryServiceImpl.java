package com.trash_sorter.service;



import com.trash_sorter.dao.CategoryDAO;
import com.trash_sorter.dao.CategoryDaoFactory;
import com.trash_sorter.dao.CategoryDaoImpl;
import com.trash_sorter.model.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDAO dao;

    private static volatile CategoryServiceImpl instance;
    private CategoryServiceImpl() {
        this.dao = new CategoryDaoFactory().getDao();
    }
    public static CategoryServiceImpl getInstance(){
        if (instance == null){
            synchronized (CategoryDaoImpl.class){
                if (instance == null)
                    instance = new CategoryServiceImpl();
            }
        }
        return instance;
    }
    @Override
    public boolean addNewCategory(Category cat) {
        return dao.addNewCategory(cat);
    }

    @Override
    public boolean deleteCategory(Category cat) {
        return dao.deleteCategory(cat);
    }

    @Override
    public Category getCategoryById(long id) {
        return dao.getCategoryById(id);
    }

    @Override
    public List<String> getCategoriesName() {
        return dao.getCategoriesName();
    }

    @Override
    public List<Category> getAllCategories() {
        return dao.getAllCategories();
    }
}
