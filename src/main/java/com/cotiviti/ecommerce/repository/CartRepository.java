package com.cotiviti.ecommerce.repository;

import com.cotiviti.ecommerce.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(int userId);
}
