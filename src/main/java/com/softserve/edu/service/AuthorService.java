package com.softserve.edu.service;

import com.softserve.edu.entity.Author;
import java.util.List;


/**
 * Created by Ruslan on 11.12.2015.
 */
public interface AuthorService {
    public void save(Author author);
    public void update(Author author);
    public Author find(Integer elementId);
    public List<Author> findAll();
    public void delete(Integer id);
}
