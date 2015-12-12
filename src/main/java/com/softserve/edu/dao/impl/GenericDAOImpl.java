package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.GenericDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Богдан on 09.12.2015.
 */
@Repository
public abstract class GenericDAOImpl<E> implements GenericDAO<E> {
    private Class<E> entityClass;

    public GenericDAOImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(E element) {
        sessionFactory.getCurrentSession().save(element);
    }

    @Override
    public void update(E element) {
        sessionFactory.getCurrentSession().update(element);
    }

    @Override
    public E find(Integer elementId) {
        E element = null;
        element = (E) sessionFactory.getCurrentSession().get(entityClass, elementId);
        return element;

    }

    @Override
    public List<E> findAll() {
        List<E> elements = new ArrayList<E>();
            elements = sessionFactory.getCurrentSession().createCriteria(entityClass).list();
        return elements;
    }

    @Override
    public void delete(Integer id) {
        sessionFactory.getCurrentSession().delete(id);
    }
}
