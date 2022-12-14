package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return (args -> {
			productRepository.save(new Product(null, "Ordinateur", 10000, 12));
			productRepository.save(new Product(null, "Imprimante", 1200, 16));
			productRepository.save(new Product(null, "Smartphone", 8000, 9));

			productRepository.findAll().forEach(p -> {
				System.out.println(p.toString());
			});
		});
	}

}
