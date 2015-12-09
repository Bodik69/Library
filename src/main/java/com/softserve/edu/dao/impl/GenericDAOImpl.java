package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.GenericDAO;

import java.util.List;

/**
 * Created by Богдан on 09.12.2015.
 */
public class GenericDAOImpl<E> implements GenericDAO<E> {
    private Class<E> entityClass;

    public GenericDAOImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void save(E element) {

    }

    @Override
    public void update(E element) {

    }

    @Override
    public E find(Long elementId) {
        return null;
    }

    @Override
    public List<E> findAll() {
        return null;
    }

    @Override
    public void delete(E element) {

    }
}
