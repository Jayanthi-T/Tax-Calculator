package com.example.BillingSystem.service;

import com.example.BillingSystem.entity.ProductList;

import java.util.List;

public interface ProductService {
    ProductList insert(ProductList productList);

    List<ProductList> getAllProducts();
    
    boolean isProductExists(Long id);

    ProductList saveProduct(ProductList productList);

    Double calculateTotalPrice();

    Double calculateTotalTax();

    ProductList getProductById(Long id);

    void deleteProductById(Long id);
}
