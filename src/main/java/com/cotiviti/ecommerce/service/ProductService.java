package com.cotiviti.ecommerce.service;

import com.cotiviti.ecommerce.model.Product;
import com.cotiviti.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProductById(int id){
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByCategory() {
        return new ArrayList<Product>();
    }

    public Product getProductsById(int id) {
        return productRepository.findById(id).orElse(null);
    }
}
