package com.example.shop.dto.external;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class PhoneDto {
    private Long id;
    private String model;
    private BigDecimal price;
    private Integer quantity;
}
