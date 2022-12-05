package com.example.shop.controller;

import com.example.shop.model.Order;
import com.example.shop.service.OrderService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
@RequiredArgsConstructor
public class PaymentController {
    private final OrderService orderService;

    @PostMapping
    public String pay(@RequestParam Long orderId) {
        Optional<Order> orderOptional = orderService.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            if (order.getPaid()) {
                return "Order already paid";
            } else {
                order.setPaid(true);
                orderService.save(order);
                return "Order successfully paid !";
            }
        } else {
            return "Order with id " + orderId + " not found";
        }
    }
}
