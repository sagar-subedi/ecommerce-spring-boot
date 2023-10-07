package com.cotiviti.ecommerce.controller;

import com.cotiviti.ecommerce.dto.KhaltiRequest;
import com.cotiviti.ecommerce.service.KhaltiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    KhaltiService khaltiService;

    @PostMapping
    public ResponseEntity<String> khaltiPaymentRequest(@RequestBody KhaltiRequest khaltiRequest){
        System.out.println(khaltiRequest);
        ResponseEntity<String> khaltiResponse =  khaltiService.initiateKhaltiPay(khaltiRequest);
        return khaltiResponse;

    }
}
