package com.cotiviti.ecommerce.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private String customerName;
    private  String shippingAddress;
    private int totalAmount;
    private  int userId;

}
