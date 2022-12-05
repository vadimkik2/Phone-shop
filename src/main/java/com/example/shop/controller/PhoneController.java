package com.example.shop.controller;

import com.example.shop.dto.external.PhoneDto;
import com.example.shop.dto.external.PhoneResponseDto;
import com.example.shop.dto.mapper.PhoneMapper;
import com.example.shop.service.impl.PhoneServiceImpl;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phones")
@RequiredArgsConstructor
public class PhoneController {
    private final PhoneServiceImpl phoneService;
    private final PhoneMapper phoneMapper;

    @PostMapping("/save")
    public void save(@RequestBody PhoneDto dto) {
        phoneService.save(phoneMapper.mapToModel(dto));
    }
    
    @GetMapping
    public List<PhoneResponseDto> getAll(@PageableDefault Pageable pageable) {
       return phoneService.getAll(pageable)
               .stream()
               .map(phoneMapper::mapToDto)
               .collect(Collectors.toList());
    }
}
