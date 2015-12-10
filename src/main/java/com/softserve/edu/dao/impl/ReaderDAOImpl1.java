package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.ReaderDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Богдан on 09.12.2015.
 */
@Repository
public class ReaderDAOImpl1<Reader> implements ReaderDAO<Reader> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Reader reader) {
        sessionFactory.getCurrentSession().save(reader);
    }

    @Override
    public void update(Reader reader) {
        sessionFactory.getCurrentSession().update(reader);
    }

    @Override
    public Reader find(Integer elementId) {

        return (Reader)sessionFactory.getCurrentSession().get(com.softserve.edu.entity.Reader.class, elementId);
    }

    @Override
    public List<Reader> findAll() {

        return sessionFactory.getCurrentSession().createCriteria(com.softserve.edu.entity.Reader.class).list();
    }

    @Override
    public void delete(Reader reader) {
        sessionFactory.getCurrentSession().delete(reader);

    }
}