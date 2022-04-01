package com.example.BillingSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.BillingSystem.entity.ProductList;
import com.example.BillingSystem.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    // handler method to handle list products and return mode and view
    @GetMapping("/products")
    public List<ProductList> listProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products/new")
    public ProductList createProductList(@RequestBody ProductList productList) {
        productService.insert(productList);
        return productService.saveProduct(productList);
    }

    @PostMapping("/products")
    public ProductList saveProduct(@RequestBody ProductList productList) {
        return productService.saveProduct(productList);
    }


    @GetMapping("/TotalPrice")
    public Double CalcTotalPrice(){
        return productService.calculateTotalPrice();
    }

    @GetMapping("/TotalTax")
    public Double CalcTotalTax(){
        return productService.calculateTotalTax();
    }

    // handler method to handle delete product request
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "Deleted the record successfully!";
    }


}
