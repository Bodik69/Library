package com.softserve.edu.controller;

import com.softserve.edu.entity.Author;
import com.softserve.edu.entity.Book;
import com.softserve.edu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String findAllBooks(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("author", new Author());
        model.addAttribute("books", bookService.findAll());
        return "book";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book, BindingResult result) {
        bookService.save(book);
        return "redirect:/book";
    }

    @RequestMapping(value = "/book/add/{idbook}", method = RequestMethod.GET)
    public String addBookCopy(@PathVariable("idbook") Integer idBook) {
        bookService.addBookCopy(idBook);
        return "redirect:/book";
    }


}
