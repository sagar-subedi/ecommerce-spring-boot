package com.cotiviti.ecommerce.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int userId;
    private  String fullName;
    @Column(unique = true)
    private String email;
    private String password;

}
