package com.softserve.edu.dao;


import com.softserve.edu.entity.OrderReader;

import java.util.List;

/**
 * Created by Ruslan on 10.12.2015.
 */
public interface OrderReaderDAO {
    public void save(OrderReader orderReader);
    public void update(OrderReader orderReader);
    public OrderReader find(Integer elementId);
    public List<OrderReader> findAll();
    public void delete(OrderReader orderReader);
}
