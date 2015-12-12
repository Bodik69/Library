package com.softserve.edu.service;

import com.softserve.edu.entity.Reader;

import java.util.List;

/**
 * Created by Ihor Sokolyk on 12.12.2015.
 */

public interface ReaderService {
    public void saveReader(Reader reader);
    public void updateReader(Reader reader);
    public Reader findById(Integer id);
    public List<Reader> findAll();
    public void delete (Integer id);
}