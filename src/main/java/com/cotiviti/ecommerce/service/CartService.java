package com.cotiviti.ecommerce.service;


import com.cotiviti.ecommerce.model.CartItem;
import com.cotiviti.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    public class CartService {
    private final CartRepository cartRepository;

        @Autowired
        public CartService(CartRepository cartRepository) {
            this.cartRepository = cartRepository;
        }

        public CartItem addItemToCart(CartItem cartItem) {
             return cartRepository.save(cartItem);
        }


        public List<CartItem> getCartItemsByUser(int userId) {
           List<CartItem> cartItems = cartRepository.findByUserId(userId);
            return cartItems;
        }

        public void clearCart(Long cartId, Long item) {

        }
    }



