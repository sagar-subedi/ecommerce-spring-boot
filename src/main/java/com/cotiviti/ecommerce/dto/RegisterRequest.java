package com.cotiviti.ecommerce.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private  String fullName;
    private String email;
    private  String password;
}
