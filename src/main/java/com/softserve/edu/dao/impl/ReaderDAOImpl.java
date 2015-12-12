package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.ReaderDAO;
import com.softserve.edu.entity.Reader;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Богдан on 09.12.2015.
 */
@Repository
public class ReaderDAOImpl implements ReaderDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveReader(Reader reader) {
        sessionFactory.getCurrentSession().save(reader);
    }

    @Override
    public void updateReader(Reader reader) {
        sessionFactory.getCurrentSession().update(reader);
    }

    @Override
    public Reader findById(Integer id) {
        return (Reader) sessionFactory.getCurrentSession().get(Reader.class, id);
    }

    @Override
    public List<Reader> findAll() {
        return sessionFactory.getCurrentSession().createCriteria("from Reader").list();
    }

    @Override
    public void delete(Integer id) {
        Reader reader = (Reader) sessionFactory.getCurrentSession().get(Reader.class, id);
        if (null != reader) {
            sessionFactory.getCurrentSession().delete(reader);
        }
    }
}
