package com.example.shop.repository;

import com.example.shop.model.Order;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select * from orders where orders.paid = false", nativeQuery = true)
    List<Order> findAllUnpaidOrders();
}
