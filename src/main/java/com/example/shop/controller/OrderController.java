package com.example.shop.controller;

import com.example.shop.dto.mapper.OrderMapper;
import com.example.shop.dto.request.OrderRequestDto;
import com.example.shop.dto.response.OrderResponseDto;
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

    @PostMapping
    public OrderResponseDto save(@RequestBody OrderRequestDto order) {
        return orderService.save(orderMapper.mapToModel(order));
    }
}
