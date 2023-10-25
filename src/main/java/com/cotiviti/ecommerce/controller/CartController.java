package com.cotiviti.ecommerce.controller;
import com.cotiviti.ecommerce.model.CartItem;
import com.cotiviti.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addItemToCart(@RequestBody CartItem cartItem) {
        cartService.addItemToCart(cartItem);
        return ResponseEntity.ok(cartItem + " added to the cart.");
    }

    @GetMapping("/user/{userId}")
    public List<CartItem> getCartItemByUserId(@PathVariable int userId){
       return cartService.getCartItemsByUser(userId);
    }

//    @PostMapping("/remove")
//    public ResponseEntity<String> removeItemFromCart(@RequestBody String item) {
//        if (cart.remove(item)) {
//            return ResponseEntity.ok(item + " removed from the cart.");
//        }
//        return ResponseEntity.badRequest().body(item + " not found in the cart.");
//    }


}
