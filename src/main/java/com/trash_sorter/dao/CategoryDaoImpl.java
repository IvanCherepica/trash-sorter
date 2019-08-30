package com.trash_sorter.dao;


import com.trash_sorter.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryDaoImpl implements CategoryDAO {
    private SessionFactory factory;

    public CategoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public boolean addNewCategory(Category catName) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(catName);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean deleteCategory(Category cat) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(cat);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public Category getCategoryById(long id) {
        Session session = factory.openSession();
        Category category;
        try {
            category = (Category) session.get(Category.class, id);
        }finally {
            session.close();
        }
        return category;

    }

    @Override
    public List<String> getCategoriesName() {
        Session session = factory.openSession();
        List<String> categories;
        try {
            categories = (List<String>) session.createQuery(
                    "select trashCategoria from Category").list();
        }finally {
            session.close();
        }

        return categories;
    }

    @Override
    public List<Category> getAllCategories() {
        Session session = factory.openSession();
        List<Category> categories;
        try{
            categories = (List<Category>) session.createQuery(
                    "from Category"
            ).list();
        }finally {
            session.close();
        }
        return categories;
    }
}
