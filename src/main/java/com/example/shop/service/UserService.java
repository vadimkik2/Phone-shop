package com.example.shop.service;

import com.example.shop.model.User;
import java.util.Optional;

public interface UserService {
    User save(User user);

    User get(Long id);

   Optional<User> findByEmail(String email);
}
