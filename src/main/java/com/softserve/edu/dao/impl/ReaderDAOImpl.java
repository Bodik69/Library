package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.ReaderDAO;
import com.softserve.edu.entity.Reader;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Богдан on 09.12.2015.
 */
@Repository
public class ReaderDAOImpl extends GenericDAOImpl<Reader> implements ReaderDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public ReaderDAOImpl() {
        super(Reader.class);
    }

    @Override
    public Reader findReaderById(Integer id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Reader WHERE idReader = :id");
        query.setParameter("id", id);
        return (Reader)query.uniqueResult();
    }
}
