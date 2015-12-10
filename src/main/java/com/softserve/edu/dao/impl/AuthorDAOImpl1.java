package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.AuthorDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ruslan on 10.12.2015.
 */
@Repository
public class AuthorDAOImpl1<Author> implements AuthorDAO<Author> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Author author) {
        sessionFactory.getCurrentSession().save(author);
    }

    @Override
    public void update(Author author) {
        sessionFactory.getCurrentSession().update(author);
    }

    @Override
    public Author find(Integer elementId) {
        return (Author) sessionFactory.getCurrentSession().get(com.softserve.edu.entity.Author.class,elementId);

    }

    @Override
    public List<Author> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(com.softserve.edu.entity.Author.class).list();
    }

    @Override
    public void delete(Author author) {
        sessionFactory.getCurrentSession().delete(author);

    }
}