package com.cg.capstore.CapStoreApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.cg.capstore.beans")
public class CapStoreAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapStoreAppApplication.class, args);
	}
}
