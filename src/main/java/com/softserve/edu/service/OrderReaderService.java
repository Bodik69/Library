package com.softserve.edu.service;

import com.softserve.edu.entity.OrderReader;

import java.util.List;

/**
 * Created by Богдан on 12.12.2015.
 */
public interface OrderReaderService {

    public void save(OrderReader orderReader);

    public void addDataReturn(Integer elementId);

    public void update(OrderReader orderReader, Integer idOrder);

    public OrderReader find(Integer elementId);

    public List<OrderReader> findAll();

    public void delete(Integer id);
}
