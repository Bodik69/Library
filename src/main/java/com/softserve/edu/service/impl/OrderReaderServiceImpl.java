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
    public boolean save(OrderReader orderReader) {
        boolean check = false;
        Copy copy = copyDAO.findCopyByInventory(orderReader.getCopy().getId());
        List<OrderReader> list = orderReaderDAO.findByReaderId(orderReader.getReader().getIdReader());
        Integer code = copy.getBook().getIdBook();
        for (OrderReader orderReader1:list) {
            if (orderReader1.getCopy().getBook().getIdBook() == code) {
                return false;
            }
        }

        if (copy.getIsInStock() == true) {
            orderReader.setCopy(copy);
            orderReader.getCopy().setIsInStock(false);
            Reader reader = readerDAO.findReaderById(orderReader.getReader().getIdReader());
            orderReader.setReader(reader);
            copyDAO.update(copy);
            orderReaderDAO.save(orderReader);
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public void addDataReturn(Integer elementId) {
        OrderReader orderReader = orderReaderDAO.find(elementId);
        Copy copy = copyDAO.findCopyByInventory(orderReader.getCopy().getId());
        copy.setIsInStock(true);
        copyDAO.update(copy);
        orderReader.setDataReturn(Date.valueOf(LocalDate.now()));
        orderReaderDAO.update(orderReader);

    }

    @Override
    public void update(OrderReader orderReader, Integer idOrder) {
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

    @Override
    public boolean isBookExist(OrderReader orderReader) {
        Copy copy = copyDAO.findCopyByInventory(orderReader.getCopy().getId());
        if (copy == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isReaderExist(OrderReader orderReader) {
        Reader reader = readerDAO.findReaderById(orderReader.getReader().getIdReader());
        if (reader == null) {
            return false;
        }
        return true;
    }
}
