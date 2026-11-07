package com.achraf.productbackend;

import com.achraf.productbackend.entities.Product;
import com.achraf.productbackend.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductCatalogBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatalogBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product(null, "Ordinateur Portable", 1300, true));
			productRepository.save(new Product(null, "Imprimante Multifonction", 300, false));
			productRepository.save(new Product(null, "Smartphone 5G", 800, true));
		};
	}
}