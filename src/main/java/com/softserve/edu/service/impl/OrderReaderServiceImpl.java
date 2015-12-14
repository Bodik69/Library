package com.softserve.edu.service.impl;

import com.softserve.edu.dao.CopyDAO;
import com.softserve.edu.dao.OrderReaderDAO;
import com.softserve.edu.dao.ReaderDAO;
import com.softserve.edu.entity.Copy;
import com.softserve.edu.entity.OrderReader;
import com.softserve.edu.entity.Reader;
import com.softserve.edu.service.OrderReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Богдан on 12.12.2015.
 */
@Service
@Transactional
public class OrderReaderServiceImpl implements OrderReaderService {

    @Autowired
    private OrderReaderDAO orderReaderDAO;

    @Autowired
    private CopyDAO copyDAO;

    @Autowired
    private ReaderDAO readerDAO;

    @Override
    public void save(OrderReader orderReader) {
        Copy copy = copyDAO.findCopyByInventory(orderReader.getCopy().getId());
        orderReader.setCopy(copy);
        Reader reader = readerDAO.findReaderById(orderReader.getReader().getIdReader());
        orderReader.setReader(reader);
        orderReaderDAO.save(orderReader);
    }

    @Override
    public void addDataReturn(Integer elementId) {
        OrderReader orderReader = orderReaderDAO.find(elementId);
        orderReader.setDataReturn(Date.valueOf(LocalDate.now()));
        orderReaderDAO.update(orderReader);
    }

    @Override
    public void update(OrderReader orderReader,Integer idOrder) {
        OrderReader orderReaderUpdate = find(idOrder);
        orderReaderUpdate.setCopy(orderReader.getCopy());
        orderReaderUpdate.setReader(orderReader.getReader());
        orderReaderUpdate.setDataOrder(orderReader.getDataOrder());
        orderReaderUpdate.setDataReturn(orderReader.getDataReturn());
        orderReaderDAO.update(orderReaderUpdate);
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
