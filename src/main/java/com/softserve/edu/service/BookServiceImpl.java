package com.softserve.edu.service;

import com.softserve.edu.dao.BookDAO;
import com.softserve.edu.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Богдан on 10.12.2015.
 */
@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    @Override
    public Book find(Integer id) {
        return bookDAO.find(id);
    }

    @Override
    public void save(Book book) {
        bookDAO.save(book);
    }

    @Override
    public void update(Book book) {
        bookDAO.update(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public void delete(Book book) {
        bookDAO.delete(book);
    }
}
