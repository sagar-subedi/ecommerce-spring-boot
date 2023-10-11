package com.cotiviti.ecommerce.controller;


import com.cotiviti.ecommerce.OrderStatus;
import com.cotiviti.ecommerce.dto.OrderRequest;
import com.cotiviti.ecommerce.dto.OrderStatusChangeRequest;
import com.cotiviti.ecommerce.model.Order;
import com.cotiviti.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private  OrderService orderService;


    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/create")
    public String createOrder(@RequestBody OrderRequest orderRequest){

        return orderService.createNewOrder(orderRequest);

//        return "Order creation successful";
    }

    @PostMapping("/update/{orderId}")
    public String updateOrderStatus(@PathVariable Long orderId, @RequestBody OrderStatusChangeRequest orderStatus){
        orderService.setOrderStatus(orderId, orderStatus);
        return "Order Modified";
    }

    @GetMapping("/byUser/{userId}")
    public List<Order> getOrdersByUser(@PathVariable int userId) {
        return orderService.getOrdersByUserId(userId);
    }
}