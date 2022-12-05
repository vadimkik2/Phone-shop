package com.example.shop.dto.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
