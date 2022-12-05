package com.example.shop.controller;

import com.example.shop.dto.external.OrderDto;
import com.example.shop.dto.external.OrderResponseDto;
import com.example.shop.dto.mapper.OrderMapper;
import com.example.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping("/place-order")
    public OrderResponseDto save(@RequestBody OrderDto order) {
        return orderService.save(orderMapper.mapToModel(order));
    }
}
