package com.softserve.edu.service.impl;

import com.softserve.edu.dao.OrderReaderDAO;
import com.softserve.edu.entity.OrderReader;
import com.softserve.edu.service.OrderReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Богдан on 12.12.2015.
 */
@Service
@Transactional
public class OrderReaderServiceImpl implements OrderReaderService {

    @Autowired
    private OrderReaderDAO orderReaderDAO;

    @Override
    public void save(OrderReader reader) {
        orderReaderDAO.save(reader);
    }

    @Override
    public void update(OrderReader reader) {
        orderReaderDAO.update(reader);
    }

    @Override
    public OrderReader find(Integer id) {
        return orderReaderDAO.find(id);
    }

    @Override
    public List<OrderReader> findAll() {
        return orderReaderDAO.findAll();
    }

    @Override
    public void delete(Integer id) {
        orderReaderDAO.delete(id);
    }
}
