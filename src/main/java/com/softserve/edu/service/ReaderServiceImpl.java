package com.softserve.edu.service;

import com.softserve.edu.dao.ReaderDAO;
import com.softserve.edu.entity.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Богдан on 12.12.2015.
 */
@Service
@Transactional
public class ReaderServiceImpl {

    @Autowired
    private ReaderDAO readerDAO;

    public void saveReader(Reader reader) {
        readerDAO.save(reader);
    }

    public void updateReader(Reader reader) {
        readerDAO.update(reader);
    }

    public Reader findReader(Integer id) {
        return readerDAO.find(id);
    }

    public List<Reader> findAllReaders() {
        return readerDAO.findAll();
    }

    public void deleteReader(Reader reader) {
        readerDAO.delete(reader);
    }
}
