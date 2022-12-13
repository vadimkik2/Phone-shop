package com.example.shop.dto.mapper;

import com.example.shop.dto.request.OrderRequestDto;
import com.example.shop.dto.response.OrderResponseDto;
import com.example.shop.model.Order;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderMapper implements ResponseDtoMapper<OrderResponseDto, Order>,
            RequestDtoMapper<OrderRequestDto, Order> {
    private final ProductMapper phoneMapper;

    @Override
    public OrderResponseDto mapToDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setPrice(order.getPrice());
        dto.setMessage("You placed you're order"
                + " and you're price is " + order.getPrice());
        return dto;
    }

    @Override
    public Order mapToModel(OrderRequestDto dto) {
        Order order = new Order();
        order.setPhones(dto.getPhones().stream()
                .map(phoneMapper::mapToModel).collect(Collectors.toList()));
        order.setDelete(false);
        order.setPaid(false);
        order.setPrice(dto.getPrice());
        return order;
    }
}
