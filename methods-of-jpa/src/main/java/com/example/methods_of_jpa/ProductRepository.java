package com.example.methods_of_jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByProductName(String productName);

    List<Product> findAllByProductpriceBetween(double price1, double price2);

    List<Product> findAllByProductpriceGreaterThan(double price, Sort sort);

    Optional<Product> findByProductpriceAndProductBrand(double price, String brandName);
}
