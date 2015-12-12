package com.softserve.edu.controller;

import com.softserve.edu.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Ihor Sokolyk on 12.12.2015.
 */
@Controller
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @RequestMapping(value = "/reader")
    public String ReaderName(Map<String, Object> map) {
        map.put("reader", readerService.findById(1));
        return "reader";
    }

//    @RequestMapping(value = "add", method = RequestMethod.POST)
//    public String addReader(@ModelAttribute("reader") Reader reader,BindingResult result) {
//        readerService.saveReader(reader);
//        return "reader";
//    }
//
//    @RequestMapping("delete/{readerId}")
//    public String deleteContact(@PathVariable("readerId") Integer readerId) {
//        readerService.delete(readerId);
//        return "reader";
//    }
}
