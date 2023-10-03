package com.cotiviti.ecommerce.service;

import com.cotiviti.ecommerce.dto.LoginRequest;
import com.cotiviti.ecommerce.dto.RegisterRequest;
import com.cotiviti.ecommerce.model.User;
import com.cotiviti.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserRepository userRepository;


    public void registerUser(RegisterRequest registerRequest){
        User newUser = new User();
        newUser.setEmail(registerRequest.getEmail());
        newUser.setFullName(registerRequest.getFullName());
        newUser.setPassword(registerRequest.getPassword());

        userRepository.save(newUser);
    }

    public boolean loginUser(LoginRequest loginRequest) {
        //checks database and returns true if password matches,
        User user = userRepository.findByEmail(loginRequest.getEmail());
        if(user!=null && (user.getPassword().equals(loginRequest.getPassword()))){
            return true;
        }
        return false;
    }
}
