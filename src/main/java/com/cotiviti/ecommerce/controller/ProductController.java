package com.cotiviti.ecommerce.controller;

import com.cotiviti.ecommerce.model.Product;
import com.cotiviti.ecommerce.repository.ProductRepository;
import com.cotiviti.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public List<Product> getProducts(){
        return productService.getProducts();

    }

    //Todo: implement later, currently dummy
    @GetMapping("/brand/{name}")
    public List<Product> getProductsByCategory(@PathVariable String name){
        return productService.getProductsByCategory(name);

    }

    @GetMapping("/getById/{id}")
    public Product getProductsById(@PathVariable int id){
        return productService.getProductsById(id);

    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        productService.deleteProductById(id);
    }




}
