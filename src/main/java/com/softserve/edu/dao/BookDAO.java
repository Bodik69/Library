package com.softserve.edu.dao;

import com.softserve.edu.entity.Book;

import java.util.List;

/**
 * Created by Ruslan on 10.12.2015.
 */
public interface BookDAO extends GenericDAO<Book> {

    public Book findBookByOtherBookProperties(Book book);
}
