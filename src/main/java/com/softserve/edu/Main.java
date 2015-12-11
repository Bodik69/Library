package com.softserve.edu;

import com.softserve.edu.dao.impl.DaoFactory;
import com.softserve.edu.entity.Book;
import com.softserve.edu.service.BookServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Ihor Sokolyk on 09.12.2015.
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
        BookServiceImpl bookService = ctx.getBean(BookServiceImpl.class);
        System.out.println(bookService.find(1).getAuthor().getFirstName());
    }
}

