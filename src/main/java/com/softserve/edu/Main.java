package com.softserve.edu;

import com.softserve.edu.dao.impl.DaoFactory;
import com.softserve.edu.entity.Book;


/**
 * Created by Ihor Sokolyk on 09.12.2015.
 */
public class Main {
    public static void main(String[] args) {

        Book book = DaoFactory.getInstance().getBookDAO().find(1);
        System.out.println(book.getAuthor().getFirstName());

    }
}

