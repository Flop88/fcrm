package ru.its67.fcrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.its67.fcrm.domain.Message;
import ru.its67.fcrm.domain.User;
import ru.its67.fcrm.repos.MessageRepo;
import ru.its67.fcrm.service.UserService;


import java.util.*;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private UserService userService;



    // Проверка статуса заказа для пользователя
    @GetMapping("/")
    public String greeting(@RequestParam(required = false, defaultValue = "0") String filterPhone,
                           Model model) {
        Iterable<Message> messages = messageRepo.findAll();

        if (filterPhone != null && !filterPhone.isEmpty()) {
            messages = messageRepo.findByClientPhone(filterPhone);
        }

        model.addAttribute("serviceorders", messages);
        model.addAttribute("filterPhone", filterPhone);

        return "greeting";
    }

    // Выгрузка заказов из БД + фильтры

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter,
                       @RequestParam(required = false, defaultValue = "1") String filterOrder, Model model) {
        Iterable<Message> messages = messageRepo.findAll();

//        if (filter != null && !filter.isEmpty()) {
//            messages = messageRepo.findByClientName(filter);
//        } else {
//            messages = messageRepo.findAll();
//        }

        if (filterOrder != null && !filterOrder.isEmpty()) {
            messages = messageRepo.findByOrderActive(filterOrder);

        } else {
            messages = messageRepo.findAll();
        }

        model.addAttribute("serviceorders", messages);
//        model.addAttribute("filter", filter);
        model.addAttribute("filterOrder", filterOrder);

        return "main";
    }

    // Добавить заказ!

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String firstDate, @RequestParam String orderDevice,
                      @RequestParam String orderBrand, @RequestParam String orderModel,
                      @RequestParam String clientName, @RequestParam String clientPhone, @RequestParam String orderProblem , @RequestParam String orderComment, @RequestParam String orderComplect,
            Map<String, Object> model) {
        Message message = new Message(firstDate, orderDevice, orderBrand, orderModel, clientName, clientPhone, orderProblem, user, "1", orderComment, orderComplect);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("serviceorders", messages);

        return "main";
    }

}