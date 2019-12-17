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
                            @RequestParam String clientName, @RequestParam String clientPhone, @RequestParam String orderProblem,
                            @RequestParam String orderActive, @RequestParam String orderComment, @RequestParam String orderComplect,
                            @RequestParam String orderServices, @RequestParam String orderPrice,
                            @RequestParam String secondDate, @RequestParam String orderExpenses,
                            @RequestParam String orderGaranty,
                            @RequestParam Map<String, String> form,
                            @RequestParam("orderId") Message order) {

        orderService.saveOrder(firstDate, orderDevice, orderBrand, orderModel, clientName,
                clientPhone, orderProblem, orderActive, orderComment, orderComplect,
                orderServices, orderPrice,
                secondDate, orderExpenses,orderGaranty,
                order, messageRepo);

        return "redirect:/main";
    }
}
