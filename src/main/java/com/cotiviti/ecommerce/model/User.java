package com.cotiviti.ecommerce.model;

import com.cotiviti.ecommerce.OrderStatus;
import com.cotiviti.ecommerce.enums.UserRole;
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
    @Column(unique = true)
    private  String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;

}
