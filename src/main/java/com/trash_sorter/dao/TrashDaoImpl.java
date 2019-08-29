package com.trash_sorter.dao;

import com.trash_sorter.model.Trash;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TrashDaoImpl implements TrashDAO {
    private SessionFactory factory;

    public TrashDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }


    public List<String> getAllTrashById(long id) {
        Session session = factory.openSession();
        List<String> trash;
        try{
            trash = (List<String>) session.createQuery(
                    "select name from Trash where category_id=" +id).list();
        }finally {
            session.close();
        }
        return trash;
    }

    @Override
    public List<Trash> getAllTrash() {
        Session session = factory.openSession();
        List<Trash> trash;
        try{
            trash = session.createQuery(
                    "from Trash").list();
        }finally {
            session.close();
        }

        return trash;
    }

    @Override
    public boolean deleteTrash(Trash trash) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(trash);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return true;
    }
}
