package com.cotiviti.ecommerce.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Order order;
    int productId;
    private int quantity;
    }