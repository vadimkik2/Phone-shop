package com.example.shop.dto.external;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderResponseDto {
    private BigDecimal price;
    private String message;
}
