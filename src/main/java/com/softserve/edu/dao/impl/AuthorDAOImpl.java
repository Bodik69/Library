package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.AuthorDAO;
import com.softserve.edu.entity.Author;
import com.softserve.edu.entity.Book;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.function.Predicate;

/**
 * Created by Богдан on 09.12.2015.
 */
@Repository
public class AuthorDAOImpl extends GenericDAOImpl<Author> implements AuthorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public AuthorDAOImpl() {
        super(Author.class);
    }

    @Override
    public Author findAuthorByFullName(String firstName, String lastName) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Author WHERE firstName = :first AND lastName = :last");
        query.setParameter("first", firstName);
        query.setParameter("last", lastName);
        return (Author)query.uniqueResult();
    }

    @Override
    public void deleteBookByID(Author author,final Integer id) {
        author.getBooks().removeIf(new Predicate<Book>() {
            public boolean test(Book book) {
                return book.getIdBook().equals(id);
            }
        });
    }
}
