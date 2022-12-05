package com.example.shop.dto.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
