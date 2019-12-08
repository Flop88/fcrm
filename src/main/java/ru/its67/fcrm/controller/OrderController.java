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
@RequestMapping("/order")
@PreAuthorize("hasAuthority('ADMIN')")
public class OrderController {
    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private OrderService orderService;

    @GetMapping
    public String orderList(Model model) {
        model.addAttribute("orders", messageRepo.findAll());

        return "orders";
    }

    @GetMapping("{order}")
    public String orderEditForm(@PathVariable Message order, Model model){
        model.addAttribute("order", order);

        return "ordersEdit";
    }

    @PostMapping
    public String orderSave(@RequestParam String firstDate, @RequestParam String orderDevice,
                            @RequestParam String orderBrand, @RequestParam String orderModel,
                            @RequestParam String clientName, @RequestParam String clientPhone,
                            @RequestParam String orderActive, @RequestParam String orderComment,
                            @RequestParam String orderServices, @RequestParam String orderPrice,
                            @RequestParam String order_seconddate, @RequestParam String order_expenses,
                            @RequestParam String order_garanty, @RequestParam Map<String, String> form,
                            @RequestParam("orderId") Message order) {

        orderService.saveOrder(firstDate, orderDevice, orderBrand, orderModel, clientName,
                clientPhone, orderActive, orderComment, orderServices, orderPrice,
                order_seconddate, order_expenses,order_garanty, order, messageRepo);

        return "redirect:/main";
    }
}
