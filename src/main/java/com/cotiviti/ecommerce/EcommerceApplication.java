package com.cotiviti.ecommerce;

import com.cotiviti.ecommerce.model.Product;
import com.cotiviti.ecommerce.model.User;
import com.cotiviti.ecommerce.repository.ProductRepository;
import com.cotiviti.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//initial dummy data insertion here
//		User user1 = new User();
//		User user2 = new User();
//
//		Product product1 = new Product();
//		Product product2 = new Product();
//
//		user1.setEmail("sagarsubedi01@gmail.com");
//		user1.setFullName("Sagar Subedi");
//		user1.setPassword(passwordEncoder.encode("sagar111"));
//		user1.setUsername("sagar");
//
//		user2.setEmail("sushila@gmail.com");
//		user2.setFullName("Sushila Subedi");
//		user2.setPassword(passwordEncoder.encode("sushila111"));
//		user2.setUsername("sushila");
//
//		product1.setName("Apple Airpods Max");
//		product1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");
//		product1.setImageUrl("https://oss.gadgetbytenepal.com/wp-content/uploads/2020/12/Apple-AirPods-Max-Design.jpg");
//		product1.setPrice(549);
//
//
//		product2.setName("iPhone 15");
//		product2.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");
//		product2.setImageUrl("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-15-model-unselect-gallery-2-202309_GEO_US?wid=5120&hei=2880&fmt=p-jpg&qlt=80&.v=1692925254305");
//		product2.setPrice(899);
//
//		userRepository.save(user1);
//		userRepository.save(user2);
//
//		productRepository.save(product1);
//		productRepository.save(product2);
	}


}
