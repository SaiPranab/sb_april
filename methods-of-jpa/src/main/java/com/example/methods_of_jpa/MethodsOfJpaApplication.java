package com.example.methods_of_jpa;

import java.util.List;

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
		Page<Product> products4 = productRepository.findAll(PageRequest.of(0, 5,
				Sort.by(Direction.DESC, "productprice")));
		products4.forEach(System.out::println);
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
