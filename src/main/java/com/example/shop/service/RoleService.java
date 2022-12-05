package com.example.shop.service;

import com.example.shop.model.Role;

public interface RoleService {
    void save(Role role);

    Role getByName(String roleName);
}
