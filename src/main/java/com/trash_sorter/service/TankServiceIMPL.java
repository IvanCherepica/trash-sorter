package com.trash_sorter.service;

import com.trash_sorter.dao.TankDAO;
import com.trash_sorter.dao.TankDaoImpl;
import com.trash_sorter.model.Tank;
import com.trash_sorter.util.Builder;
import com.trash_sorter.util.DbHelper;

import java.util.List;

public class TankServiceIMPL implements TankService {
    DbHelper helper = DbHelper.getInstance(Builder.getConfiguration());
    private final TankDAO dao;

    private static volatile TankServiceIMPL instance;
    private TankServiceIMPL(){
        this.dao = new TankDaoImpl(helper.getFactory());
    }
    public static TankServiceIMPL getInstance(){
        if (instance == null){
            synchronized (TankServiceIMPL.class){
                if (instance == null)
                    instance = new TankServiceIMPL();
            }
        }
        return instance;
    }

    @Override
    public boolean addNewTank(Tank tank) {
        return dao.addNewTank(tank);
    }

    @Override
    public boolean deleteTank(Tank tank) {
        return dao.deleteTank(tank);
    }

    @Override
    public Tank getTankById(long id) {
        return dao.getTankById(id);
    }

    @Override
    public List<Tank> getTanks() {
        return dao.getTanks();
    }
}
