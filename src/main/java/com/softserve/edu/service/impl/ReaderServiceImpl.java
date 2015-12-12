package com.softserve.edu.service.impl;

import com.softserve.edu.dao.ReaderDAO;
import com.softserve.edu.entity.Reader;
import com.softserve.edu.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ihor Sokolyk on 12.12.2015.
 */
@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderDAO readerDAO;

    @Override
    @Transactional
    public void save(Reader reader) {
        readerDAO.save(reader);
    }

    @Override
    @Transactional
    public void update(Reader reader) {
        readerDAO.update(reader);
    }

    @Override
    @Transactional
    public Reader findById(Integer id) {
        return readerDAO.find(id);
    }

    @Override
    @Transactional
    public List<Reader> findAll() {
        return readerDAO.findAll();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        readerDAO.delete(id);
    }
}
