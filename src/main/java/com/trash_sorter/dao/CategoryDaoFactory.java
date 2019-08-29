package com.trash_sorter.dao;

import com.trash_sorter.util.Builder;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class CategoryDaoFactory {
    private CategoryDAO dao;

    public CategoryDaoFactory(){
        dao = new CategoryDaoImpl(createSessionFactory(Builder.getConfiguration()));
    }

    public CategoryDAO getDao() {
        return dao;
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
