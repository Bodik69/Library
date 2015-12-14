package com.softserve.edu.controller;

import com.softserve.edu.entity.Copy;
import com.softserve.edu.entity.OrderReader;
import com.softserve.edu.entity.Reader;
import com.softserve.edu.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.text.resources.pl.CollationData_pl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Ihor Sokolyk on 12.12.2015.
 */
@Controller
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @RequestMapping(value = "/reader", method = RequestMethod.GET)
    public String ReaderList(Model model) {
        List<Reader> readers = readerService.findAll();
        model.addAttribute("reader", new Reader());
        model.addAttribute("readerList", readers);
        return "reader";
    }


    @RequestMapping(value = "/reader", method = RequestMethod.POST)
    public String addReader(@ModelAttribute("reader") Reader reader, BindingResult result) {
        reader.setDateOfCreate(Date.valueOf(LocalDate.now()));
        readerService.save(reader);
        return "redirect:/reader";
    }

    @RequestMapping("delete/{idReader}")
    public String deleteReader(@PathVariable("idReader") Integer idReader) {
        readerService.delete(idReader);
        return "redirect:/reader";
    }

    @RequestMapping("edit/{idReader}")
    public String editReader(@PathVariable("idReader") Integer idReader, Model model) {
        model.addAttribute("readerId", idReader);
        model.addAttribute("flag", true);
        return "reader";
    }

    @RequestMapping("/save/{idReader}")
    public String updateReader(@PathVariable("idReader") Integer idReader) {
        readerService.update(readerService.findById(idReader));
        return "redirect:/reader";
    }
}
