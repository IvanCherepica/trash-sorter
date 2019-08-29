package com.trash_sorter.service;


import com.trash_sorter.dao.AdminDAO;
import com.trash_sorter.dao.AdminDaoFactory;
import com.trash_sorter.model.Admin;

public class AdminServiceIMPL implements AdminService {
    private AdminDAO dao;

    private static volatile AdminServiceIMPL instance;
    private AdminServiceIMPL(){
        this.dao = new AdminDaoFactory().getDao();
    }
    public static AdminServiceIMPL getInstance(){
        if (instance == null){
            synchronized (AdminServiceIMPL.class){
                if (instance == null){
                    instance = new AdminServiceIMPL();
                }
            }
        }
        return instance;
    }

    @Override
    public Admin getAdminByName(String adminName) {
        return dao.getAdminByName(adminName);
    }
}
