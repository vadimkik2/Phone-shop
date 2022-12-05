package com.example.shop.service.impl;

import com.example.shop.model.User;
import com.example.shop.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = userService.findByEmail(email);
        UserBuilder builder;
        if (optionalUser.isPresent()) {
            builder = org.springframework.security.core.userdetails.User.withUsername(email);
            builder.password(optionalUser.get().getPassword());
            builder.roles(optionalUser.get().getRoles()
                    .stream()
                    .map(role -> role.getRoleName().name())
                    .toArray(String[]::new));
            return builder.build();
        }
        throw new UsernameNotFoundException("User not found!");
    }
}
