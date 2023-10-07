package com.cotiviti.ecommerce.dto;

import com.cotiviti.ecommerce.OrderStatus;
import lombok.Data;
import lombok.Value;

@Data
public class OrderStatusChangeRequest {
    private OrderStatus orderStatus;
}
