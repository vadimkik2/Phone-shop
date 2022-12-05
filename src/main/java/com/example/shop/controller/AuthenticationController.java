package com.example.shop.controller;


import com.example.shop.dto.external.UserRequestDto;
import com.example.shop.dto.external.UserResponseDto;
import com.example.shop.dto.mapper.ResponseDtoMapper;
import com.example.shop.model.User;
import com.example.shop.service.AuthenticationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final ResponseDtoMapper<UserResponseDto, User> dtoMapper;

    public AuthenticationController(AuthenticationService authService,
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
