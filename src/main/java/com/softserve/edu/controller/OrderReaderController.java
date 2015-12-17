package com.softserve.edu.controller;

import com.softserve.edu.entity.Copy;
import com.softserve.edu.entity.OrderReader;
import com.softserve.edu.entity.Reader;
import com.softserve.edu.service.OrderReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by Ruslan on 13.12.2015.
 */
@Controller
public class OrderReaderController {

    @Autowired
    private OrderReaderService orderReaderService;

    private boolean check = true;
    private boolean flag = true;
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String findAllOrders(Model model) {
        model.addAttribute("reader", new Reader());
        model.addAttribute("copy", new Copy());
        model.addAttribute("orderReader", new OrderReader());
        model.addAttribute("orders", orderReaderService.findAll());
        model.addAttribute("check", check);
        model.addAttribute("flag", flag);
        check = true;
        flag = true;
        return "order";
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("orderReader") OrderReader orderReader, BindingResult result) {
        boolean checkInventoryId = orderReaderService.isBookExist(orderReader);
        boolean checkReaderById = orderReaderService.isReaderExist(orderReader);
        if (checkInventoryId && checkReaderById) {
            orderReader.setDataOrder(Date.valueOf(LocalDate.now()));
            check = orderReaderService.save(orderReader);
        }
        else {
            flag = false;
        }
        return "redirect:/order";
    }

    @RequestMapping(value = "/order/return/{idOrder}", method = RequestMethod.GET)
    public String addDataReturn(@PathVariable("idOrder") Integer id) {
        orderReaderService.addDataReturn(id);
        return "redirect:/order";
    }

    @RequestMapping("/order/delete/{idOrder}")
    public String deleteOrder(@PathVariable("idOrder") Integer idOrder) {
        orderReaderService.delete(idOrder);
        return "redirect:/order";
    }

    @RequestMapping("editOrder/{idOrder}")
    public String editOrder(@PathVariable("idOrder") Integer idOrder, Model model) {
        OrderReader orderReader = orderReaderService.find(idOrder);
        model.addAttribute("orderReader", orderReader);
        model.addAttribute("id", idOrder);
        return "editOrderReader";
    }

    @RequestMapping(value = "/order/delete", method = RequestMethod.POST)
    public String deleteAllSelected(@RequestParam("idlist")Integer[] list) {
        for (int i = 0; i < list.length; i++) {
            orderReaderService.delete(list[i]);
        }
        return "redirect:/order";
    }

    @RequestMapping(value = "editOrder/saveOrder/{idOrder}", method = RequestMethod.POST)
    public String updateOrder(@PathVariable("idOrder") Integer idOrder,
                               @ModelAttribute("orderReader") OrderReader orderReader, BindingResult result) {
        boolean checkInventoryId = orderReaderService.isBookExist(orderReader);
        boolean checkReaderById = orderReaderService.isReaderExist(orderReader);
        if (checkInventoryId && checkReaderById) {
            orderReaderService.update(orderReader, idOrder);
        }
        else {
            flag = false;
        }
        return "redirect:/order";
    }
}
