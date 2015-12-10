package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.OrderReaderDAO;
import com.softserve.edu.entity.OrderReader;

/**
 * Created by Богдан on 09.12.2015.
 */
public class OrderReaderDAOImpl extends GenericDAOImpl<OrderReader> implements OrderReaderDAO{

    public OrderReaderDAOImpl() {
        super(OrderReader.class);
    }
}
