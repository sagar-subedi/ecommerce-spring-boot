package com.cotiviti.ecommerce.controller;

import com.cotiviti.ecommerce.dto.LoginRequest;
import com.cotiviti.ecommerce.dto.RegisterRequest;
import com.cotiviti.ecommerce.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired  
    private AuthService authService;

    @GetMapping("/users")
    public String getUsers(){
        return "Ram, Shyam, Hari";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest registerRequest){
        authService.registerUser(registerRequest);
        return "Successfull Registration";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest){
        boolean isValid = authService.loginUser(loginRequest);
        if(isValid) return "User credentials valid";
        return  "Users credentials not matched";
    }
}
