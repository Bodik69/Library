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
@Transactional
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderDAO readerDAO;

    @Override
    public void saveReader(Reader reader) {
        readerDAO.saveReader(reader);
    }

    @Override
    public void updateReader(Reader reader) {
        readerDAO.updateReader(reader);
    }

    @Override
    public Reader findById(Integer id) {
        return readerDAO.findById(id);
    }

    @Override
    public List<Reader> findAll() {
        return readerDAO.findAll();
    }

    @Override
    public void delete(Integer id) {
        readerDAO.delete(id);
    }
}
