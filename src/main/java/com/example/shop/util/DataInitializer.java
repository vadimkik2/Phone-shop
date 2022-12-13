package com.example.shop.util;

import com.example.shop.model.Role;
import com.example.shop.model.User;
import com.example.shop.service.RoleService;
import com.example.shop.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.MANAGER);
        roleService.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.save(userRole);

        User user = new User();
        user.setEmail("admin@adm.ua");
        user.setPassword("admin123456");
        user.setRoles(Set.of(adminRole));
        userService.save(user);

        User user2 = new User();
        user2.setEmail("pavlo@uk.ua");
        user2.setPassword("Pavlo123456");
        user2.setRoles(Set.of(userRole));
        userService.save(user2);
    }
}
