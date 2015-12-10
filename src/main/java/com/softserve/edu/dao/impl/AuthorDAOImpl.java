package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.AuthorDAO;
import com.softserve.edu.entity.Author;

/**
 * Created by Богдан on 09.12.2015.
 */
public class AuthorDAOImpl extends GenericDAOImpl<Author> implements AuthorDAO {

    public AuthorDAOImpl() {
        super(Author.class);
    }
}
