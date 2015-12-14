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
    public Boolean save(Reader reader) {
        Reader r = readerDAO.findReaderByFullName(reader.getName(), reader.getSurname(), reader.getBirth());
        if (r == null){
            readerDAO.save(reader);
            return false;
        }else {
            return true;
        }
    }

    @Override
    @Transactional
    public void update(Reader reader, Integer id) {
        Reader reader1 = findById(id);
        reader1.setPhone(reader.getPhone());
        reader1.setName(reader.getName());
        reader1.setSurname(reader.getSurname());
        reader1.setBirth(reader.getBirth());
        reader1.setAdress(reader.getAdress());
        readerDAO.update(reader1);
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
