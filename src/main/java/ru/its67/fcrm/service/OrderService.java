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
                                 @RequestParam String orderModel, @RequestParam String clientName, @RequestParam String clientPhone, @RequestParam String orderProblem,
                                 @RequestParam String orderActive, @RequestParam String orderComment, @RequestParam String orderComplect,
                                 @RequestParam String orderServices, @RequestParam String orderPrice,
                                 @RequestParam String orderSecondDate, @RequestParam String orderExpenses, @RequestParam String orderGaranty,
                                 @RequestParam("orderId") Message order, MessageRepo messageRepo) {

        order.setFirstDate(firstDate);
        order.setOrderDevice(orderDevice);
        order.setOrderBrand(orderBrand);
        order.setOrderModel(orderModel);
        order.setClientName(clientName);
        order.setClientPhone(clientPhone);
        order.setOrderProblem(orderProblem);
        order.setOrderActive(orderActive);
        order.setOrderComment(orderComment);
        order.setOrderComplect(orderComplect);
        order.setOrderServices(orderServices);
        order.setOrderPrice(orderPrice);
        order.setSecondDate(orderSecondDate);
        order.setOrderExpenses(orderExpenses);
        order.setOrderGaranty(orderGaranty);

        if(!orderSecondDate.isEmpty())
        {
            order.setOrderActive("0");
        }
        else {
            order.setOrderActive("1");
        }

        messageRepo.save(order);
    }
}
