package com.cotiviti.ecommerce.model;

import com.cotiviti.ecommerce.OrderStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    private String orderId;
    private int userId;
    private String customerName;
    private Date orderDate;
    private String shippingAddress;
    private double totalAmount;

//    private List<OrderItem> orderItems;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
