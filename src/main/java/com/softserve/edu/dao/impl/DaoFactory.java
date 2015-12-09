package com.softserve.edu.dao.impl;

import com.softserve.edu.entity.Copy;

/**
 * Created by Богдан on 09.12.2015.
 */
public class DaoFactory {
    private AuthorDAOImpl authorDAO;
    private BookDAOImpl bookDAO;
    private CopyDAOImpl copyDAO;
    private OrderReaderDAOImpl orderReaderDAO;
    private ReaderDAOImpl readerDAO;

    private static DaoFactory instance;

    public DaoFactory() {
        authorDAO = new AuthorDAOImpl();
        bookDAO = new BookDAOImpl();
        copyDAO = new CopyDAOImpl();
        orderReaderDAO = new OrderReaderDAOImpl();
        readerDAO = new ReaderDAOImpl();
    }

    public static DaoFactory getInstance() {
        if(instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    public AuthorDAOImpl getAuthorDAO() {
        return authorDAO;
    }

    public BookDAOImpl getBookDAO() {
        return bookDAO;
    }

    public CopyDAOImpl getCopyDAO() {
        return copyDAO;
    }

    public OrderReaderDAOImpl getOrderReaderDAO() {
        return orderReaderDAO;
    }

    public ReaderDAOImpl getReaderDAO() {
        return readerDAO;
    }
}
