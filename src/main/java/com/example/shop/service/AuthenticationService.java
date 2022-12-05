package com.example.shop.service;


import com.example.shop.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
