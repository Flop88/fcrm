package ru.its67.fcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.its67.fcrm.domain.Message;
import ru.its67.fcrm.repos.MessageRepo;


@Service
public class OrderService {

    @Autowired
    private MessageRepo messageRepo;

    public static void saveOrder(@RequestParam String firstDate, @RequestParam String orderDevice, @RequestParam String orderBrand, @RequestParam String orderModel, @RequestParam String clientName, @RequestParam String clientPhone, @RequestParam String orderActive, @RequestParam("orderId") Message order, MessageRepo messageRepo) {
        order.setFirstDate(firstDate);
        order.setOrderDevice(orderDevice);
        order.setOrderBrand(orderBrand);
        order.setOrderModel(orderModel);
        order.setClientName(clientName);
        order.setClientPhone(clientPhone);
        order.setOrderActive(orderActive);

        messageRepo.save(order);
    }
}
