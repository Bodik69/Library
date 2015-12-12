package com.softserve.edu.service;

import com.softserve.edu.entity.Book;

import java.util.List;

/**
 * Created by Ruslan on 11.12.2015.
 */

public interface BookService {

    public void save(Book book);

    public void update(Book book);

    public Book find(Integer elementId);

    public List<Book> findAll();

    public void delete(Integer id);
}
