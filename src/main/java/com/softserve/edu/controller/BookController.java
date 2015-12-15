package com.softserve.edu.controller;

import com.softserve.edu.entity.Author;
import com.softserve.edu.entity.Book;
import com.softserve.edu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private String error;

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String findAllBooks(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("author", new Author());
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("error", error);
        error = null;
        return "book";
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book, BindingResult result) {
        bookService.save(book);
        return "redirect:/book";
    }

    @RequestMapping(value = "/book/add/{idBook}")
    public String addBookCopy(@PathVariable("idBook") Integer idBook, @RequestParam("count") Integer count) {
        if(count != null) {
            bookService.addNCopyOfBook(idBook, count);
        }
        return "redirect:/book";
    }

    @RequestMapping(value = "/book/edit/{idBook}", method = RequestMethod.GET)
    public String editBookPage(@PathVariable("idBook") Integer idBook, Model model) {
        Book book = bookService.find(idBook);
        if(book == null) {
            return "redirect:/book";
        }
        model.addAttribute("book", book);
        return "editBook";
    }

    @RequestMapping(value = "/book/edit/{idBook}", method = RequestMethod.POST)
    public String editBookInfo(@ModelAttribute("book") Book book, @PathVariable("idBook") Integer idBook, BindingResult result) {
        bookService.updateBookById(book, idBook);
        return "redirect:/book";
    }

    @RequestMapping(value = "/book/delete", method = RequestMethod.POST)
    public String deleteAllSelected(@RequestParam("idlist")Integer[] list) {
        List<Integer> notDeletedBooks = new ArrayList<>();
        for(Integer id: list) {
            if(!bookService.removeAllCopies(id)) {
                notDeletedBooks.add(id);
            }
        }
        if(notDeletedBooks.size() > 0) {
            error = "Деякі книги неможливо видалити оскільки вони знаходяться у читачів";
        }
        return "redirect:/book";
    }

    @RequestMapping(value = "/book/remove/{idBook}", method = RequestMethod.GET)
    public String removeAllCopiesOfBook(@PathVariable("idBook") Integer idBook) {
        if(!bookService.removeAllCopies(idBook)) {
            error = "Неможливо видалити книгу якщо вона знаходиться у читача";
        }
        return "redirect:/book";
    }

}
