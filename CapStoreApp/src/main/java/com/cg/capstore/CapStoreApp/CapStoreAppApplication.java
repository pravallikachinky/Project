package com.cg.capstore.CapStoreApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.cg.capstore.beans")
@ComponentScan("com.cg.capstore")
@EnableJpaRepositories("com.cg.capstore")
public class CapStoreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapStoreAppApplication.class, args);
	}
}
