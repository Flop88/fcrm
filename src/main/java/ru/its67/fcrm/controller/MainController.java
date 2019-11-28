package ru.its67.fcrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.its67.fcrm.domain.Message;
import ru.its67.fcrm.repos.MessageRepo;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("serviceorders", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String firstDate,  @RequestParam String orderDevice,
                      @RequestParam String orderBrand, @RequestParam String orderModel,
                      @RequestParam String clientName, @RequestParam String clientPhone,
                                                       Map<String, Object> model) {
        Message message = new Message(firstDate, orderDevice, orderBrand,
                                orderModel, clientName, clientPhone);
        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("serviceorders", messages);

        return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByClientName(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("serviceorders", messages);

        return "main";
    }
}