package com.example.shop.controller;

import com.example.shop.dto.mapper.ResponseDtoMapper;
import com.example.shop.dto.request.UserRequestDto;
import com.example.shop.dto.response.UserResponseDto;
import com.example.shop.model.User;
import com.example.shop.service.RegistrationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final RegistrationService authService;
    private final ResponseDtoMapper<UserResponseDto, User> dtoMapper;

    public RegistrationController(RegistrationService authService,
                                  ResponseDtoMapper<UserResponseDto, User> dtoMapper) {
        this.authService = authService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Validated UserRequestDto requestDto) {
        User user = authService.register(requestDto.getEmail(), requestDto.getPassword());
        return dtoMapper.mapToDto(user);
    }
}
