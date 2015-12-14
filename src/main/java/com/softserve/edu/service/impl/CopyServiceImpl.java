package com.softserve.edu.service.impl;

import com.softserve.edu.dao.AuthorDAO;
import com.softserve.edu.dao.CopyDAO;
import com.softserve.edu.entity.Author;
import com.softserve.edu.entity.Copy;
import com.softserve.edu.service.CopyService;
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
    public void delete(Integer id) {
        copyDAO.delete(id);
    }

    public boolean isAllCopiesOfBookInStock(Integer idOfBook) {
        boolean result = true;
        List<Copy> copies = copyDAO.findAll();
        for(Copy copy: copies) {
            if(copy.getBook().getIdBook().equals(idOfBook) && !copy.getIsInStock()) {
                result = false;
                break;
            }
        }
        return result;
    }
}
