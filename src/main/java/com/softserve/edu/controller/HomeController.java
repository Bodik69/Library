package com.softserve.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Богдан on 12.12.2015.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String showInitialPage() {
        return "index";
    }
}
