package com.example.shop.service.impl;

import com.example.shop.model.Role;
import com.example.shop.repository.RoleRepository;
import com.example.shop.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    @Override
    public void save(Role role) {
        repository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return repository.getRoleByRoleName(roleName)
                .orElseThrow(() -> new RuntimeException("Can't get role: "
                        + roleName));
    }
}
