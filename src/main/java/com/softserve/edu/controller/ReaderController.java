package com.softserve.edu.controller;

import com.softserve.edu.entity.Reader;
import com.softserve.edu.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/reader")
    public String ReaderName(Model model) {
        List<Reader> readers = readerService.findAll();
        model.addAttribute("readerList", readers);
        return "reader";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addReader(@RequestParam("name") String name, @RequestParam("surname") String surname,
                            @RequestParam("address") String address, @RequestParam("phone") String phone,
                            @RequestParam("birth") String birth) {
        Reader reader = new Reader();
        reader.setName(name);
        reader.setSurname(surname);
        reader.setAdress(address);
        reader.setPhone(phone);
        reader.setBirth(Date.valueOf(birth));
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
        List<Reader> readers = readerService.findAll();
        model.addAttribute("readerList", readers);
        return "reader";
    }

    @RequestMapping("/save/{idReader}")
    public String updateReader(@PathVariable("idReader") Integer idReader) {
        readerService.update(readerService.findById(idReader));
        return "redirect:/reader";
    }
}
