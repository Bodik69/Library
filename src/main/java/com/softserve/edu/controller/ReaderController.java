package com.softserve.edu.controller;

import com.softserve.edu.entity.Reader;
import com.softserve.edu.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
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
        map.put("reader", readerService.findById(8));
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
        readerService.saveReader(reader);
        return "redirect:/reader";
    }

    @RequestMapping("delete/{idReader}")
    public String deleteContact(@PathVariable("idReader") Integer idReader) {
        readerService.delete(idReader);
        return "redirect:/reader";
    }
}
