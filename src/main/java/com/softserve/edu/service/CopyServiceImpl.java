package com.softserve.edu.service;

import com.softserve.edu.dao.AuthorDAO;
import com.softserve.edu.dao.CopyDAO;
import com.softserve.edu.entity.Author;
import com.softserve.edu.entity.Copy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ruslan on 11.12.2015.
 */
@Service
@Transactional
public class CopyServiceImpl implements CopyService {
    @Autowired
    private CopyDAO copyDAO;

    @Override
    public Copy find(Integer id) {
        return copyDAO.find(id);
    }

    @Override
    public void save(Copy copy) {
        copyDAO.save(copy);
    }

    @Override
    public void update(Copy copy) {
        copyDAO.update(copy);
    }

    @Override
    public List<Copy> findAll() {
        return copyDAO.findAll();
    }

    @Override
    public void delete(Copy copy) {
        copyDAO.delete(copy);
    }
}
