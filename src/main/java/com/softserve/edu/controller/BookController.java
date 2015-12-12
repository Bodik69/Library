package com.softserve.edu.controller;

import com.softserve.edu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/book")
    public String findBookAuthor(Map<String, Object> map) {
        map.put("book", bookService.find(1).getAuthor().getFirstName());
        return "App";
    }
}
