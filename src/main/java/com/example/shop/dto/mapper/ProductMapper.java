package com.example.shop.dto.mapper;

import com.example.shop.dto.request.ProductRequestDto;
import com.example.shop.dto.response.ProductResponseDto;
import com.example.shop.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements RequestDtoMapper<ProductRequestDto, Product>,
        ResponseDtoMapper<ProductResponseDto, Product> {

    @Override
    public Product mapToModel(ProductRequestDto dto) {
        Product phone = new Product();
        phone.setId(dto.getId());
        phone.setModel(dto.getModel());
        phone.setPrice(dto.getPrice());
        phone.setQuantity(dto.getQuantity());
        return phone;
    }

    @Override
    public ProductResponseDto mapToDto(Product phone) {
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(phone.getId());
        dto.setModel(phone.getModel());
        dto.setPrice(phone.getPrice());
        dto.setQuantity(phone.getQuantity());
        return dto;
    }
}
