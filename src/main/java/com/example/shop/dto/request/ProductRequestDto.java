package com.example.shop.dto.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductRequestDto {
    private Long id;
    private String model;
    private BigDecimal price;
    private Integer quantity;
}
