package com.sai;
 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages={"com.sai", "com.sai.*"})

public class FoodApplication { 

	public static void main(String[] args) {
		SpringApplication.run(FoodApplication.class, args);
	} 

}
