package com.softserve.edu.controller;

import com.softserve.edu.service.AuthorService;
import com.softserve.edu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Ruslan on 11.12.2015.
 */
@Controller
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @RequestMapping("/author")
    public String findSurname(Map<String, Object> map) {
        map.put("author", authorService.find(1).getLastName());
        return "TestAuthor";
    }
}
