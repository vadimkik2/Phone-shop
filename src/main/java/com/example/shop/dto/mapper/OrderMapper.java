package com.example.shop.dto.mapper;

import com.example.shop.dto.external.OrderDto;
import com.example.shop.dto.external.OrderResponseDto;
import com.example.shop.model.Order;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order>,RequestDtoMapper<OrderDto, Order> {
    private final PhoneMapper phoneMapper;
    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setPrice(order.getPrice());
        dto.setMessage("You placed you're order"
                + " and you're price is " + order.getPrice());
        return dto;
    }

    @Override
    public Order mapToModel(OrderDto dto) {
        Order order = new Order();
        order.setPhones(dto.getPhones().stream().map(phoneMapper::mapToModel).collect(Collectors.toList()));
        order.setDelete(false);
        order.setPaid(false);
        order.setPrice(dto.getPrice());
        return order;
    }
}