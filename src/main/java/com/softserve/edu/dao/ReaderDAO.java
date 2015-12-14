package com.softserve.edu.dao;

import com.softserve.edu.entity.Reader;

import java.sql.Date;

/**
 * Created by Ruslan on 10.12.2015.
 */
public interface ReaderDAO extends GenericDAO<Reader>{

    public Reader findReaderById(Integer id);

    public Reader findReaderByFullName(String name, String surname, Date birth);
}
