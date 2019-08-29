package com.trash_sorter.service;


import com.trash_sorter.model.Tank;

import java.util.List;

public interface TankService {
    boolean addNewTank(Tank tank);
    boolean deleteTank(Tank tank);
    Tank getTankById(long id);
    List<Tank> getTanks();
    void editTanksCategory(long tankId, long categoryId);
}
