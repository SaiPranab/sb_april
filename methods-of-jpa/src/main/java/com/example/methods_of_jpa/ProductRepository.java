package com.example.methods_of_jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByProductName(String productName);

    List<Product> findAllByProductpriceBetween(double price1, double price2);

    List<Product> findAllByProductpriceGreaterThan(double price, Sort sort);

    Optional<Product> findByProductpriceAndProductBrand(double price, String brandName);

    // JPQL -> positional parameters, named parameters
    @Query("SELECT p FROM Product p WHERE p.productprice=?2 AND p.productBrand=?1") // positional parameter
    Optional<Product> getProduct(String brandName, double price);

    @Query("SELECT p FROM Product p WHERE p.productprice=:price AND p.productBrand=:brandName") // named parameter
    Optional<Product> getProduct1(@Param("brandName") String brandName1, @Param("price") double price1);

    // Plain SQL or Raw SQL or Native SQL
    @Query(nativeQuery = true, value = "SELECT * FROM product WHERE productprice=:price AND product_brand=:name")
    Optional<Product> getProduct2(String name, double price);

    // @Modifying
    // @Transactional
    // @Query(nativeQuery = true, value = "UPDATE product SET productprice=? WHERE
    // product_brand=?")
    // int updateprice(double price, String brand);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Product p SET p.productprice=:price WHERE p.productBrand=:brand")
    int updateprice(double price, String brand);
}
