package com.example.shop.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class OrderResponseDto {
    private BigDecimal price;
    private String message;
}
