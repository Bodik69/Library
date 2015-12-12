package com.softserve.edu.service.impl;

import com.softserve.edu.dao.OrderReaderDAO;
import com.softserve.edu.entity.OrderReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Богдан on 12.12.2015.
 */
@Service
@Transactional
public class OrderReaderServiceImpl {

    @Autowired
    private OrderReaderDAO orderReaderDAO;

    public void saveOrder(OrderReader reader) {
        orderReaderDAO.save(reader);
    }

    public void updateOrder(OrderReader reader) {
        orderReaderDAO.update(reader);
    }

    public OrderReader findOrder(Integer id) {
        return orderReaderDAO.find(id);
    }

    public List<OrderReader> findAllOrders() {
        return orderReaderDAO.findAll();
    }

    public void deleteOrder(OrderReader reader) {
        orderReaderDAO.delete(reader);
    }
}
