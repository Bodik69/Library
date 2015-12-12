package com.softserve.edu.service;

import com.softserve.edu.dao.AuthorDAO;
import com.softserve.edu.dao.BookDAO;
import com.softserve.edu.entity.Author;
import com.softserve.edu.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ruslan on 11.12.2015.
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public Author find(Integer id) {
        return authorDAO.find(id);
    }

    @Override
    public void save(Author author) {
        authorDAO.save(author);
    }

    @Override
    public void update(Author author) {
        authorDAO.update(author);
    }

    @Override
    public List<Author> findAll() {
        return authorDAO.findAll();
    }

    @Override
    public void delete(Author author) {
        authorDAO.delete(author);
    }
}
