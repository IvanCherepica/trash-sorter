package com.trash_sorter.dao;

import com.trash_sorter.model.Tank;

import java.util.List;

public interface TankDAO {
    boolean addNewTank(Tank tank);
    boolean deleteTank(Tank tank);
    Tank getTankById(long id);
    List<Tank> getTanks();
}
