package com.softserve.edu.dao;

import com.softserve.edu.entity.Book;

import java.util.List;

/**
 * Created by Ruslan on 10.12.2015.
 */
public interface BookDAO {

    public void save(Book book);
    public void update(Book book);
    public Book find(Integer elementId);
    public List<Book> findAll();
    public void delete(Book book);
}
