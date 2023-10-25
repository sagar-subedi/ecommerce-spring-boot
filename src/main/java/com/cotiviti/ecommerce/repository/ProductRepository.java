package com.cotiviti.ecommerce.repository;

import com.cotiviti.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findByBrand(String brandName);
}
