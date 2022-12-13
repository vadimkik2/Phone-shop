package com.example.shop.dto.request;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class OrderRequestDto {
    private Long id;
    private List<ProductRequestDto> phones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductRequestDto> getPhones() {
        return phones;
    }

    public void setPhones(List<ProductRequestDto> phones) {
        this.phones = phones;
    }

    public BigDecimal getPrice() {
        return phones.stream()
                .map(ProductRequestDto::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderRequestDto orderDto = (OrderRequestDto) o;
        return Objects.equals(id, orderDto.id) && Objects.equals(phones, orderDto.phones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phones);
    }
}
