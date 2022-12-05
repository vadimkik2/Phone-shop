package com.example.shop.dto.mapper;

import com.example.shop.dto.external.PhoneDto;
import com.example.shop.dto.external.PhoneResponseDto;
import com.example.shop.model.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneMapper implements RequestDtoMapper<PhoneDto, Phone>,
    ResponseDtoMapper<PhoneResponseDto, Phone>{

    @Override
    public Phone mapToModel(PhoneDto dto) {
        Phone phone = new Phone();
        phone.setId(dto.getId());
        phone.setModel(dto.getModel());
        phone.setPrice(dto.getPrice());
        phone.setQuantity(dto.getQuantity());
        return phone;
    }

    @Override
    public PhoneResponseDto mapToDto(Phone phone) {
        PhoneResponseDto dto = new PhoneResponseDto();
        dto.setId(phone.getId());
        dto.setModel(phone.getModel());
        dto.setPrice(phone.getPrice());
        dto.setQuantity(phone.getQuantity());
        return dto;
    }
}
