package com.cotiviti.ecommerce.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int productId;
    private int quantity;
    private int userId;
}
