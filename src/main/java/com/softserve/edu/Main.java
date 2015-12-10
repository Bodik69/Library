package com.softserve.edu;

import com.softserve.edu.dao.impl.DaoFactory;
import com.softserve.edu.entity.Book;
import com.softserve.edu.service.BookServiceImpl;


/**
 * Created by Ihor Sokolyk on 09.12.2015.
 */
public class Main {
    public static void main(String[] args) {

        BookServiceImpl bookService = new BookServiceImpl();
        Book result = bookService.find(1);

    }
}

