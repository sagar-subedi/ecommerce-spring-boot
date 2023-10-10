package com.cotiviti.ecommerce.repository;

import com.cotiviti.ecommerce.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository  extends JpaRepository<OrderItem, Long> {

}
