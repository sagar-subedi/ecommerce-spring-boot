package com.cotiviti.ecommerce.dto;

import lombok.Data;

import java.util.List;

@Data
public class KhaltiRequest {
    private String return_url;
    private String website_url;
    private int amount;
    private String purchase_order_id;
    private String purchase_order_name;
    private CustomerInfo customer_info;
    private List<AmountBreakdown> amount_breakdown;
    private List<ProductDetails> product_details;
}

@Data
class CustomerInfo {
    private String name;
    private String email;
    private String phone;
}

@Data
class AmountBreakdown {
    private String label;
    private int amount;

}

@Data
class ProductDetails {
    private String identity;
    private String name;
    private int total_price;
    private int quantity;
    private int unit_price;

}
