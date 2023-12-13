package com.scheduling.nutritionist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.scheduling.nutritionists")
public class NutritionistApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutritionistApplication.class, args);
	}

}
