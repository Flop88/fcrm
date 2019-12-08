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

    public static void saveOrder(@RequestParam String firstDate, @RequestParam String orderDevice, @RequestParam String orderBrand,
                                 @RequestParam String orderModel, @RequestParam String clientName, @RequestParam String clientPhone,
                                 @RequestParam String orderActive, @RequestParam String orderComment, @RequestParam String orderServices,
                                 @RequestParam String orderPrice,   @RequestParam String order_seconddate, @RequestParam String order_expenses,
                                 @RequestParam String order_garanty,
                                 @RequestParam("orderId") Message order, MessageRepo messageRepo) {
        order.setFirstDate(firstDate);
        order.setOrderDevice(orderDevice);
        order.setOrderBrand(orderBrand);
        order.setOrderModel(orderModel);
        order.setClientName(clientName);
        order.setClientPhone(clientPhone);
        order.setOrderActive(orderActive);
        order.setOrderComment(orderComment);
        order.setOrderServices(orderServices);
        order.setOrderPrice(orderPrice);
        order.setOrderSecondDate(order_seconddate);
        order.setOrderExpenses(order_expenses);
        order.setOrderGaranty(order_garanty);

        if(!orderPrice.isEmpty() && !order_seconddate.isEmpty())
        {
            order.setOrderActive("0");
        } else
        {
            order.setOrderActive("1");
        }

        messageRepo.save(order);
    }
}
