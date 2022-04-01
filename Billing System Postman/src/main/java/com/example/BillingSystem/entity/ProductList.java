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


//    @Override
//    public String toString() {
//        return "ProductList{" +
//                "productType='" + productType + '\'' +
//                '}';
//    }
//
    public Double getTotalPriceReceipt() {
        Double total_tax = 0.0;
        Double total_price = 0.0;
        Double taxPerProduct = 0.0;

        if (productType.contains("imported")) {
            if (productType.contains("book") || productType.contains("food") || productType.contains("medicine")) {
                taxPerProduct = unitPrice * 0.05;
                unitPrice = (unitPrice + taxPerProduct) * quantity;
                total_tax += (taxPerProduct * quantity);
                total_price += unitPrice;
            }
            else {
                taxPerProduct = unitPrice * 0.15;
                unitPrice = (unitPrice + taxPerProduct)*quantity;
                total_tax += (taxPerProduct * quantity);
                total_price += unitPrice;
            }
        }
        else {
            if (productType.contains("book") || productType.contains("food") || productType.contains("medicine")) {
                unitPrice = (unitPrice * quantity);
                total_price += unitPrice;
            }
            else {
                taxPerProduct = unitPrice * 0.10;
                unitPrice = (unitPrice + taxPerProduct)*quantity;
                total_tax += (taxPerProduct * quantity);
                total_price += unitPrice;
            }
        }
        return total_price;
    }


    public Double getTotalTaxReceipt() {
        Double total_tax = 0.0;
        Double total_price = 0.0;
        Double taxPerProduct = 0.0;

        if (productType.contains("imported")) {
            if (productType.contains("book") || productType.contains("food") || productType.contains("medicine")) {
                taxPerProduct = unitPrice * 0.05;
                unitPrice = (unitPrice + taxPerProduct) * quantity;
                total_tax += (taxPerProduct * quantity);
                total_price += unitPrice;
            }
            else {
                taxPerProduct = unitPrice * 0.15;
                unitPrice = (unitPrice + taxPerProduct)*quantity;
                total_tax += (taxPerProduct * quantity);
                total_price += unitPrice;
            }
        }
        else {
            if (productType.contains("book") || productType.contains("food") || productType.contains("medicine")) {
                unitPrice = (unitPrice * quantity);
                total_price += unitPrice;
            }
            else {
                taxPerProduct = unitPrice * 0.10;
                unitPrice = (unitPrice + taxPerProduct)*quantity;
                total_tax += (taxPerProduct * quantity);
                total_price += unitPrice;
            }
        }
        return total_tax;
    }

}
