package com.softserve.edu;

import com.softserve.edu.dao.impl.DaoFactory;
import com.softserve.edu.entity.Book;
import com.softserve.edu.entity.Reader;
import com.softserve.edu.util.HibernateUtil;
import org.hibernate.Session;


/**
 * Created by Ihor Sokolyk on 09.12.2015.
 */
public class Main {
    public static void main(String[] args) {

        Book book = DaoFactory.getInstance().getBookDAO().find(1);
        System.out.println(book.getAuthor().getFirstName());
    }
}

