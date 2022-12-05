package com.example.shop.dto.external;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class OrderDto {
    private Long id;
    private List<PhoneDto> phones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PhoneDto> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDto> phones) {
        this.phones = phones;
    }
    public BigDecimal getPrice() {
        return phones.stream()
                .map(PhoneDto::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(id, orderDto.id) && Objects.equals(phones, orderDto.phones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phones);
    }
}
