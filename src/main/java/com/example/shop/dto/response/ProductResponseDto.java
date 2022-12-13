package com.example.shop.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductResponseDto {
    private Long id;
    private String model;
    private BigDecimal price;
    private Integer quantity;
}
