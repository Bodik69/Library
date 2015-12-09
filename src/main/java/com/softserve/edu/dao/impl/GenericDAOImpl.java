package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.GenericDAO;
import com.softserve.edu.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
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
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(element);
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }

    }

    @Override
    public void update(E element) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(element);
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }

    }

    @Override
    public E find(Integer elementId) {
        Session session = null;
        E element = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            element = (E) session.get(entityClass, elementId);
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return element;

    }

    @Override
    public List<E> findAll() {
        Session session = null;
        List<E> elements = new ArrayList<E>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            elements = session.createCriteria(entityClass).list();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return elements;


    }

    @Override
    public void delete(E element) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(element);
            transaction.commit();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }
}
