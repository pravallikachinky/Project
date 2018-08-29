package com.cg.equipement.EquipmentTrackingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.cg.equipment.equipmentTrackingRepo")
@EntityScan("com.cg.equipment.bean")
@ComponentScan("com.cg.equipment")
public class EquipmentTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EquipmentTrackingSystemApplication.class, args);
	}
}
