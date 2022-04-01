package com.example.BillingSystem.service.impl;

import com.example.BillingSystem.entity.ProductList;
import com.example.BillingSystem.repository.ProductRepository;
import com.example.BillingSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Override
    public ProductList insert(ProductList productList){
        return productRepository.save(productList);
    }

    @Override
    public List<ProductList> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public ProductList getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public ProductList saveProduct(ProductList productList) {
         return productRepository.save(productList);
    }


    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }


    @Override
    public Double calculateTotalPrice(){

        AtomicReference<Double> taxPerProduct = new AtomicReference<>(0.0);
        AtomicReference<Double> total_tax = new AtomicReference<>(0.0);
        AtomicReference<Double> total_price = new AtomicReference<>(0.0);
        AtomicReference<Double> unitPrice = new AtomicReference<>(0.0);

        List<ProductList> productList = getAllProducts();
        productList.forEach(product-> {

            if (product.getProductType().contains("imported")) {
                if (product.getProductType().contains("book") || product.getProductType().contains("food") || product.getProductType().contains("medicine")) {
                    taxPerProduct.set(product.getUnitPrice() * 0.05);
                    unitPrice.set((product.getUnitPrice() + taxPerProduct.get()) * product.getQuantity());
                    total_tax.updateAndGet(v -> v + (taxPerProduct.get() * product.getQuantity()));
                    total_price.updateAndGet(v -> v + product.getUnitPrice());
                }
                else {
                    taxPerProduct.set(product.getUnitPrice() * 0.15);
                    unitPrice.set((product.getUnitPrice() + taxPerProduct.get()) * product.getQuantity());
                    total_tax.updateAndGet(v -> v + (taxPerProduct.get() * product.getQuantity()));
                    total_price.updateAndGet(v -> v + product.getUnitPrice());
                }
            }
            else {
                if (product.getProductType().contains("book") || product.getProductType().contains("food") || product.getProductType().contains("medicine")) {
                    unitPrice.set((product.getUnitPrice() + taxPerProduct.get()) * product.getQuantity());
                    total_price.updateAndGet(v -> v + product.getUnitPrice());
                }
                else {
                    taxPerProduct.set(product.getUnitPrice() * 0.10);
                    unitPrice.set((product.getUnitPrice() + taxPerProduct.get()) * product.getQuantity());
                    total_tax.updateAndGet(v -> v + (taxPerProduct.get() * product.getQuantity()));
                    total_price.updateAndGet(v -> v + product.getUnitPrice());
                }
            }

        });

        return total_price.get();

    }

    @Override
    public Double calculateTotalTax(){

        AtomicReference<Double> total_tax = new AtomicReference<>(0.0);
        AtomicReference<Double> total_price = new AtomicReference<>(0.0);
        AtomicReference<Double> taxPerProduct = new AtomicReference<>(0.0);
        AtomicReference<Double> unitPrice = new AtomicReference<>(0.0);

        List<ProductList> productList = getAllProducts();
        productList.forEach(product-> {


            if (product.getProductType().contains("imported")) {
                if (product.getProductType().contains("book") || product.getProductType().contains("food") || product.getProductType().contains("medicine")) {
                    taxPerProduct.set(product.getUnitPrice() * 0.05);
                    unitPrice.set((product.getUnitPrice() + taxPerProduct.get()) * product.getQuantity());
                    total_tax.updateAndGet(v -> v + (taxPerProduct.get() * product.getQuantity()));
                    total_price.updateAndGet(v -> v + product.getUnitPrice());
                }
                else {
                    taxPerProduct.set(product.getUnitPrice() * 0.15);
                    unitPrice.set((product.getUnitPrice() + taxPerProduct.get()) * product.getQuantity());
                    total_tax.updateAndGet(v -> v + (taxPerProduct.get() * product.getQuantity()));
                    total_price.updateAndGet(v -> v + product.getUnitPrice());
                }
            }
            else {
                if (product.getProductType().contains("book") || product.getProductType().contains("food") || product.getProductType().contains("medicine")) {
                    unitPrice.set((product.getUnitPrice() + taxPerProduct.get()) * product.getQuantity());
                    total_price.updateAndGet(v -> v + product.getUnitPrice());
                }
                else {
                    taxPerProduct.set(product.getUnitPrice() * 0.10);
                    unitPrice.set((product.getUnitPrice() + taxPerProduct.get()) * product.getQuantity());
                    total_tax.updateAndGet(v -> v + (taxPerProduct.get() * product.getQuantity()));
                    total_price.updateAndGet(v -> v + product.getUnitPrice());
                }
            }

        });

        return total_tax.get();

    }

}
