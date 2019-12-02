package ru.its67.fcrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.its67.fcrm.domain.Message;
import ru.its67.fcrm.domain.User;
import ru.its67.fcrm.repos.MessageRepo;


import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "Пользователь") String name, Map<String, Object> model) {
        model.put("model", model);
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter,@RequestParam(required = false, defaultValue = "1") String filterOrder, Model model) {
        Iterable<Message> messages = messageRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByClientName(filter);
        } else {
            messages = messageRepo.findAll();
        }

        if (filterOrder == "1") {
            messages = messageRepo.findAll();
        } else {
            messages = messageRepo.findByOrderActive(filterOrder);
        }

        model.addAttribute("serviceorders", messages);
        model.addAttribute("filter", filter);
        model.addAttribute("filterOrder", filterOrder);

        return "main";
    }

//    @GetMapping("/main")
//    public String showAll(@RequestParam(required = false, defaultValue = "1") String filterOrder, Model model) {
//        Iterable<Message> messages = messageRepo.findAll();
//
//        if (filterOrder == "1") {
//            messages = messageRepo.findAll();
//        } else {
//            messages = messageRepo.findByOrderActive(filterOrder);
//        }
//
//        model.addAttribute("filterOrder", filterOrder);
//
//        return "main";
//    }

    @PostMapping("/main")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String firstDate, @RequestParam String orderDevice,
                      @RequestParam String orderBrand, @RequestParam String orderModel,
                      @RequestParam String clientName, @RequestParam String clientPhone, @RequestParam String orderActive,
            Map<String, Object> model) {
        Message message = new Message(firstDate, orderDevice, orderBrand,
                                orderModel, clientName, clientPhone, user, orderActive);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("serviceorders", messages);

        return "main";
    }
}