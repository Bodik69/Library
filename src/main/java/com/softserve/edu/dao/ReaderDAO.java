package com.softserve.edu.dao;

import com.softserve.edu.entity.OrderReader;
import com.softserve.edu.entity.Reader;

import java.sql.Date;
import java.util.List;

/**
 * Created by Ruslan on 10.12.2015.
 */
public interface ReaderDAO extends GenericDAO<Reader>{

    public Reader findReaderById(Integer id);

    public Reader findReaderByFullName(String name, String surname, Date birth);

    public List<OrderReader> findOwerReaders(Integer id);
}
