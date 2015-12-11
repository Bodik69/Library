package com.softserve.edu.service;

import com.softserve.edu.dao.BookDAO;
import com.softserve.edu.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Богдан on 10.12.2015.
 */
@Service
public class BookServiceImpl {

    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public Book find(Integer id) {
        return bookDAO.find(id);
    }
}
