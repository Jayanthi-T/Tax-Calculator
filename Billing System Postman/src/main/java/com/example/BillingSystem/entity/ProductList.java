package com.example.BillingSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unitPrice")
    private Double unitPrice;

    public ProductList() { //Default constructor

    }

    //Constructor
    public ProductList(String productType, Integer quantity, Double unitPrice) {
        super();
        this.productType = productType;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice() {
        this.unitPrice = unitPrice;
    }

