package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.BookDAO;
import com.softserve.edu.entity.Book;

/**
 * Created by Богдан on 09.12.2015.
 */
public class BookDAOImpl extends GenericDAOImpl<Book> implements BookDAO {

    public BookDAOImpl() {
        super(Book.class);
    }
}
