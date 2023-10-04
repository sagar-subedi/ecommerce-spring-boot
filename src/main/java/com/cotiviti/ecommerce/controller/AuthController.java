package com.cotiviti.ecommerce.controller;

import com.cotiviti.ecommerce.dto.*;
import com.cotiviti.ecommerce.service.AuthService;
import com.cotiviti.ecommerce.service.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired  
    private AuthService authService;

    @Autowired
    private RefreshTokenService refreshTokenService;

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
    public TokenResponse loginUser(@RequestBody LoginRequest loginRequest){
        return  authService.loginUser(loginRequest);
    }

    @PostMapping("/token/new")
    public TokenResponse newTokenRequest(@RequestBody NewTokenRequest newTokenRequest){
        return authService.refreshToken(newTokenRequest);
    }

    @PostMapping("/logout")
    public String logout(@RequestBody NewTokenRequest logoutRequest){
        refreshTokenService.deleteRefreshToken(logoutRequest.getRefreshToken());
        return "Refresh Token Deleted Successful";

    }

}
