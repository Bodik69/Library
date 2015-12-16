package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.OrderReaderDAO;
import com.softserve.edu.entity.OrderReader;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Богдан on 09.12.2015.
 */
@Repository
public class OrderReaderDAOImpl extends GenericDAOImpl<OrderReader> implements OrderReaderDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public OrderReaderDAOImpl() {
        super(OrderReader.class);
    }

    public List<OrderReader> findByReaderId(Integer idReader) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM OrderReader WHERE idReader = :id AND dataReturn IS NULL");
        query.setParameter("id", idReader);
        return query.list();

    }
}
