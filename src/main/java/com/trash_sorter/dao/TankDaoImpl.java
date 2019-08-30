package com.trash_sorter.dao;


import com.trash_sorter.model.Tank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TankDaoImpl implements TankDAO {
    private SessionFactory factory;

    public TankDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public boolean addNewTank(Tank tankName) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(tankName);
            transaction.commit();
            return false;
        }catch (Exception e){
            System.out.println("Can't add " + e.getMessage());
            transaction.rollback();
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean deleteTank(Tank tank) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(tank);
            transaction.commit();
        }catch (Exception e){
            System.out.println("Can't delete " + e.getMessage());
            transaction.rollback();
        }finally {
            session.close();
        }
        return true;
    }

    @Override
    public Tank getTankById(long id) {
        Session session = factory.openSession();
        Tank user;
        try{
            user = (Tank) session.get(Tank.class, id);
        }finally {
            session.close();
        }
        return user;
    }

    @Override
    public List<Tank> getTanks() {
        Session session = factory.openSession();
        List<Tank> tanks;
        try {
            tanks = session.createQuery(
                    "from Tank").list();
        }finally {
            session.close();
        }

        return tanks;
    }


}
