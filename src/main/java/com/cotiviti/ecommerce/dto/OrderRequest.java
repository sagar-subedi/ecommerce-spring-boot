package com.cotiviti.ecommerce.dto;

import com.cotiviti.ecommerce.model.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private String customerName;
    private  String shippingAddress;
    private int totalAmount;
    private  int userId;
    List<OrderItem> orderItems;
}
