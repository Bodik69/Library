package com.softserve.edu.controller;

import com.softserve.edu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/book")
    public String findBookAuthor(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "book";
    }
}
