package ru.its67.fcrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.its67.fcrm.domain.Message;
import ru.its67.fcrm.repos.MessageRepo;
import ru.its67.fcrm.service.OrderService;

import java.util.Map;

@Controller
@RequestMapping("/act")
@PreAuthorize("hasAuthority('ADMIN')")
public class ActController {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private OrderService orderService;

    @GetMapping
    public String actList(Model model) {
        model.addAttribute("acts", messageRepo.findAll());
        return "act";
    }

    @GetMapping("priem/{order}")
    public String actPriema(@PathVariable Message order, Model model){
        model.addAttribute("act", order);

        return "actPriema";
    }

    @GetMapping("vidachi/{order}")
    public String actVidachi(@PathVariable Message order, Model model){
        model.addAttribute("act", order);

        return "actVidachi";
    }
}
