package com.example.shop.controller;

import com.example.shop.dto.mapper.ProductMapper;
import com.example.shop.dto.request.ProductRequestDto;
import com.example.shop.dto.response.ProductResponseDto;
import com.example.shop.service.impl.ProductServiceImpl;
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
public class ProductController {
    private final ProductServiceImpl phoneService;
    private final ProductMapper phoneMapper;

    @PostMapping
    public void save(@RequestBody ProductRequestDto dto) {
        phoneService.save(phoneMapper.mapToModel(dto));
    }
    
    @GetMapping
    public List<ProductResponseDto> getAll(@PageableDefault Pageable pageable) {
        return phoneService.getAll(pageable)
               .stream()
               .map(phoneMapper::mapToDto)
               .collect(Collectors.toList());
    }
}
