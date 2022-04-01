package com.example.BillingSystem.repository;

import com.example.BillingSystem.entity.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductList, Long> {

//    Double getTotalPriceReceipt();
//    Double getTotalTaxReceipt();
}
