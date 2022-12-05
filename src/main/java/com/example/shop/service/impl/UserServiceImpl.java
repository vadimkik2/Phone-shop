package com.example.shop.service.impl;


import com.example.shop.model.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.UserService;
import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.encoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);

    }
}
