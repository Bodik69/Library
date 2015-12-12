package com.softserve.edu.controller;

import com.softserve.edu.service.BookServiceImpl;
import com.softserve.edu.service.OrderReaderServiceImpl;
import com.softserve.edu.service.ReaderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Богдан on 11.12.2015.
 */
@Controller
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private ReaderServiceImpl readerService;

    @Autowired
    private OrderReaderServiceImpl orderReaderService;

    @RequestMapping(value = "/")
    public String showInitialPage() {
        return "index";
    }

    @RequestMapping("/book")
    public String findBookAuthor(Map<String, Object> map) {
        map.put("book", bookService.find(1).getAuthor().getFirstName());
        return "App";
    }

    @RequestMapping("/order")
    public String findOrder(Map<String, Object> map) {
        map.put("order", orderReaderService.findOrder(1).getReader().getName());
        return "App";
    }
}
