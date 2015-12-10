package com.softserve.edu.dao;

import com.softserve.edu.entity.Author;

import java.util.List;

/**
 * Created by Ruslan on 10.12.2015.
 */
public interface AuthorDAO {

    public void save(Author author);
    public void update(Author author);
    public Author find(Integer elementId);
    public List findAll();
    public void delete(Author author);
}
