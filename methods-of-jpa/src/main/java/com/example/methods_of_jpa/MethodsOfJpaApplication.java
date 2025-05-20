package com.example.methods_of_jpa;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class MethodsOfJpaApplication implements CommandLineRunner {
	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(MethodsOfJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product product = Product.builder()
				.productName("Iphone 16 pro max")
				.productBrand("Apple")
				.productprice(150000.99)
				.build();

		// SAVE
		// productRepository.save(product);

		// SAVE ALL
		List<Product> products = getProducts();
		// productRepository.saveAll(products);

		// count
		System.out.println("total rows available in the table " + productRepository.count());

		// EXISTS
		System.out.println(
				"is apple product exists " + productRepository.existsById("da513078-080b-4113-92d6-5ba1454bb2c0"));

		// DELTE By ID
		productRepository.deleteById("da513078-080b-4113-92d6-5ba1454bb2c0");

		// FiND ALL
		List<Product> products2 = productRepository.findAll();
		// products2.forEach(System.out::println);

		List<Product> products3 = productRepository.findAll(Sort.by(Direction.ASC, "productprice"));
		// products3.forEach(System.out::println);

		// PAGINATION
		// Page<Product> products4 = productRepository.findAll(PageRequest.of(0, 3));
		// Page<Product> products4 = productRepository.findAll(PageRequest.of(0, 5,
		// Sort.by(Direction.DESC, "productprice")));
		// products4.forEach(System.out::println);

		// FIND BY ID
		// Optional<Product> optProduct =
		// productRepository.findById("34ceb32f-3349-450d-b379-015c72e84da5");
		// Product existingProduct = optProduct.orElseThrow(() -> new
		// NoSuchElementException("product not found by id "));
		// System.out.println("find by id " + existingProduct);

		// SAVE or UPDATE -> if the id already exist in the table then update the obj
		// otherwise insert the obj
		// Optional<Product> optProduct =
		// productRepository.findById("34ceb32f-3349-450d-b379-015c72e84da5");
		// Product existingProduct = optProduct.orElseThrow(() -> new
		// NoSuchElementException("product not found by id "));

		// System.out.println("before update " + existingProduct);

		// existingProduct.setProductName("Iphone 18 pro max");
		// existingProduct.setProductprice(145000.99);

		// Product savedProduct = productRepository.save(existingProduct);
		// System.out.println("after update " + savedProduct);

		// FINY BY PRODUCT NAME
		// Optional<Product> optProductByName = productRepository
		// .findByProductName("Iphone 17 pro max");
		// Product productByName = optProductByName.orElseThrow();
		// System.out.println("produt by name " + productByName);

		// FIND ALL BY PRODUCT PRICE BETWEEN
		// List<Product> productsBetweenRange =
		// productRepository.findAllByProductpriceBetween(6000.00, 9000.00);
		// productsBetweenRange.forEach(System.out::println);

		// FIND ALL BY PRODUCT PRICE GREATER THAN
		// List<Product> productsGreaterThanPrice =
		// productRepository.findAllByProductpriceGreaterThan(9000.00,
		// Sort.by(Direction.ASC, "productprice"));

		// productsGreaterThanPrice.forEach(System.out::println);

		// FIND BY PRODUCT PRICE AND PRODUCT BRAND
		Optional<Product> productByPriceAndbrand = productRepository.findByProductpriceAndProductBrand(150000.99,
				"Apple");
		System.out.println("produc by price and brand " + productByPriceAndbrand.orElseThrow());

	}

	private List<Product> getProducts() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		return numbers.stream()
				.map(number -> Product.builder()
						.productName("product - " + number)
						.productBrand("brand - " + number)
						.productprice(number * 1000.50)
						.build())
				.toList();
	}
}
