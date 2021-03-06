package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.CopyDAO;
import com.softserve.edu.entity.Copy;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Богдан on 09.12.2015.
 */
@Repository
public class CopyDAOImpl extends GenericDAOImpl<Copy> implements CopyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public CopyDAOImpl() {
        super(Copy.class);
    }

    @Override
    public Copy findCopyByInventory(Integer id) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Copy WHERE inventoryNumber = :inv");
        query.setParameter("inv", id);
        return (Copy)query.uniqueResult();
    }

    @Override
    public List getAllCopiesOfBook(Integer idOfBook) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Copy WHERE code = :idOfBook");
        query.setParameter("idOfBook", idOfBook);
        return query.list();
    }


}
