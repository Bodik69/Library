package com.softserve.edu.controller;

import com.softserve.edu.entity.Copy;
import com.softserve.edu.entity.OrderReader;
import com.softserve.edu.entity.Reader;
import com.softserve.edu.service.OrderReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Ruslan on 13.12.2015.
 */
@Controller
public class OrderReaderController {

    @Autowired
    private OrderReaderService orderReaderService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String findAllOrders(Model model) {
        model.addAttribute("reader",new Reader());
        model.addAttribute("copy",new Copy());
        model.addAttribute("orderReader",new OrderReader());
        model.addAttribute("orders", orderReaderService.findAll());
        return "order";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("orderReader") OrderReader orderReader, BindingResult result) {
        orderReaderService.save(orderReader);
        return "redirect:/order";
    }
}
