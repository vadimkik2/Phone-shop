package com.example.shop.repository;

import com.example.shop.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getById(Long id);

    @Query( "select u " +
            "from User u " +
            "left join fetch u.roles "+
            "where u.email = :email ")
    Optional<User> findByEmail(String email);
}
