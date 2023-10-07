package com.cotiviti.ecommerce.repository;

import com.cotiviti.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(int userId);

}
