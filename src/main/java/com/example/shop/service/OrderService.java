package com.example.shop.service;

import com.example.shop.dto.response.OrderResponseDto;
import com.example.shop.model.Order;
import java.util.Optional;

public interface OrderService {
    Optional<Order> findById(Long id);

    OrderResponseDto save(Order order);
}
