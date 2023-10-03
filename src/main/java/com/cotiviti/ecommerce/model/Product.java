package com.cotiviti.ecommerce.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String name;
    private  String description;
    private  String imageUrl;
    private int price;

}
