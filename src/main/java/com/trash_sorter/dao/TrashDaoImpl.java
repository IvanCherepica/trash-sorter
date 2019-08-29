package com.trash_sorter.dao;


import com.trash_sorter.model.Trash;
import org.hibernate.Query;
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
            Query query = session.createQuery("select name from Trash where category_id=:id");
            query.setParameter("id",id);

            trash = (List<String>)query.list();
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

    @Override
    public Trash getTrashById(long id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Trash trash = null;
        try{
            Query query = session.createQuery(
                    "from Trash where category_id=:id");
            query.setParameter("id",id);

            trash = (Trash) query.uniqueResult();
        }catch (Exception e){
            transaction.rollback();
        }finally {
            session.close();
        }
        return trash;
    }
}
