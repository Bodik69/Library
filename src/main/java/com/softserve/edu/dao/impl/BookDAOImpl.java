package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.BookDAO;
import com.softserve.edu.entity.Book;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Богдан on 09.12.2015.
 */
@Repository
@Transactional
public class BookDAOImpl extends GenericDAOImpl<Book> implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public BookDAOImpl() {
        super(Book.class);
    }

    @Override
    public Book findBookByOtherBookProperties(Book book) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Book WHERE title = :title AND edition = :edition AND year = :year AND pages = :pages AND code != :code");
        query.setParameter("title", book.getTitle());
        query.setParameter("edition", book.getEdition());
        query.setParameter("year", book.getYear());
        query.setParameter("pages", book.getPages());
        query.setParameter("code", book.getIdBook());
        return (Book)query.uniqueResult();
    }
}
