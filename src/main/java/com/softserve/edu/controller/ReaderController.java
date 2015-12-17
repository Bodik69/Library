package com.softserve.edu.controller;

import com.softserve.edu.entity.Reader;
import com.softserve.edu.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Ihor Sokolyk on 12.12.2015.
 */
@Controller
public class ReaderController {
    private Boolean exist = false;
    private Boolean canDeleteReader = true;

    @Autowired
    private ReaderService readerService;

    @RequestMapping(value = "/reader", method = RequestMethod.GET)
    public String ReaderList(Model model) {
        List<Reader> readers = readerService.findAll();
        model.addAttribute("reader", new Reader());
        model.addAttribute("readerList", readers);
        model.addAttribute("exist", exist);
        model.addAttribute("canDelete", canDeleteReader);
        exist = false;
        canDeleteReader = true;
        return "reader";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addReader(@ModelAttribute("reader") Reader reader, BindingResult result) {
        reader.setDateOfCreate(Date.valueOf(LocalDate.now()));
        exist = readerService.save(reader);
        return "redirect:/reader";
    }

    @RequestMapping(value="delete/{idReader}", method = RequestMethod.GET)
    public String deleteReader(@PathVariable("idReader") Integer idReader) {
        canDeleteReader = readerService.delete(idReader);
        return "redirect:/reader";
    }

    @RequestMapping(value = "/reader/delete", method = RequestMethod.POST)
    public String deleteAllSelected(@RequestParam("idlist")Integer[] list) {
        for (int i = 0; i < list.length; i++){
            Boolean flag = readerService.delete(list[i]);
            if (flag == false){
                canDeleteReader = flag;
            }
        }

        return "redirect:/reader";
    }

    @RequestMapping(value="edit/{idReader}", method = RequestMethod.GET)
    public String editReader(@PathVariable("idReader") Integer idReader, Model model) {
        Reader editReader = readerService.findById(idReader);
        model.addAttribute("editReader", editReader);
        model.addAttribute("reader", new Reader());
        model.addAttribute("id", idReader);
        return "editReader";
    }

    @RequestMapping(value = "edit/save/{idReader}", method = RequestMethod.POST)
    public String updateReader(@PathVariable("idReader") Integer idReader,
                               @ModelAttribute("reader") Reader reader, BindingResult result) {
        readerService.update(reader, idReader);
        return "redirect:/reader";
    }
}
