package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.ReaderDAO;
import com.softserve.edu.entity.Author;
import com.softserve.edu.entity.Reader;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
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

    @Override
    public Reader findReaderByFullName(String name, String surname, Date birth) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Reader WHERE name = :first AND surname = :last AND birth = :birthday");
        query.setParameter("first", name);
        query.setParameter("last", surname);
        query.setParameter("birthday", birth);
        return (Reader) query.uniqueResult();
    }
}
