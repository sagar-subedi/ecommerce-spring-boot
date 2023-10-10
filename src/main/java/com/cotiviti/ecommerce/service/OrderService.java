package com.cotiviti.ecommerce.service;

import com.cotiviti.ecommerce.OrderStatus;
import com.cotiviti.ecommerce.dto.OrderRequest;
import com.cotiviti.ecommerce.dto.OrderStatusChangeRequest;
import com.cotiviti.ecommerce.exceptions.OrderNotFoundException;
import com.cotiviti.ecommerce.model.Order;
import com.cotiviti.ecommerce.model.OrderItem;
import com.cotiviti.ecommerce.repository.OrderItemRepository;
import com.cotiviti.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private  OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByUserId(int userId) {
        return orderRepository.findByUserId(userId);
    }

    public String createNewOrder(OrderRequest orderRequest){
        Order newOrder = new Order();
        newOrder.setOrderDate(new Date());
        newOrder.setCustomerName(orderRequest.getCustomerName());
        newOrder.setTotalAmount(orderRequest.getTotalAmount());
        newOrder.setShippingAddress(orderRequest.getShippingAddress());
        newOrder.setUserId(orderRequest.getUserId());
        newOrder.setOrderStatus(OrderStatus.Processing);
        newOrder.setOrderItems(orderRequest.getOrderItems());
        for (OrderItem item : orderRequest.getOrderItems()) {
            orderItemRepository.save(item);
        }
        orderRepository.save(newOrder);
        return "Order Added";
    }

    public void setOrderStatus(Long orderId, OrderStatusChangeRequest orderStatus) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("No order exists"));
        order.setOrderStatus(orderStatus.getOrderStatus());
        orderRepository.save(order);
    }
}
