package com.cotiviti.ecommerce.controller;

import com.cotiviti.ecommerce.dto.*;
import com.cotiviti.ecommerce.model.User;
import com.cotiviti.ecommerce.service.AuthService;
import com.cotiviti.ecommerce.service.RefreshTokenService;
import com.cotiviti.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired  
    private AuthService authService;

    @Autowired
    private UserService userService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/userId/{username}")
    public  User getUser(@PathVariable String username) {
        return userService.getUserRepository().findByUsername(username);
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
