# Tax-Calculator-in-Spring-Boot-and-Postman

# Billing System : Tax Problem in Spring Boot, tested using Postman

Calculate and apply basic sales tax for the products sold in a departmental store.

## Description

A department store needs to calculate and apply basic sales tax for the products sold in its stores. Sales tax is applied as standard 10% for all items, except Books, Food and Medical products.

An additional 5% import duty is levied on all imported products, with no exceptions.

Write a program to prepare and print the receipt for every purchase. The receipt should list the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. 
The rounding rulesfor sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

## Getting Started

### Dependencies

* IntelliJ IDEA as IDE
* MySQL workbench
* Postman for testing the endpoints

### Installing and Modifications

* Clone the "Billling System in Spring Boot" folder
* Change the sql username and password in "application.properties" according to your mysql installation

### Executing the Program

* Open the project in IDE
* Now run the project as spring boot application
* Go to Postman and test the endpoints

* GET Endpoint 
```
localhost:8080/products
```
* POST Endpoint
```
localhost:8080/products/new
```
This POST request returns the Tax and Price of the product that is newly added.

* DELETE Endpoint
```
localhost:8080/products/{id}
```

* GET Endpoint to calculate the TotalPrice
```
localhost:8080/TotalPrice
```

* GET Endpoint to calculate the TotalTax
```
localhost:8080/TotalTax
```

## Author

Jayanthi-T


## License

This project is licensed under the [Jayanthi-T] License 
