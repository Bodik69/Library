package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.AuthorDAO;
import com.softserve.edu.entity.Author;
import org.springframework.stereotype.Repository;

/**
 * Created by Богдан on 09.12.2015.
 */
@Repository
public class AuthorDAOImpl extends GenericDAOImpl<Author> implements AuthorDAO {

    public AuthorDAOImpl() {
        super(Author.class);
    }
}
