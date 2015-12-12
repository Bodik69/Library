package com.softserve.edu.dao;

import com.softserve.edu.entity.Reader;

import java.util.List;

/**
 * Created by Ruslan on 10.12.2015.
 */
public interface ReaderDAO {
    public void saveReader(Reader reader);
    public void updateReader(Reader reader);
    public Reader findById(Integer id);
    public List<Reader> findAll();
    public void delete (Integer id);
}
