package com.example.producthexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.producthexagonal.entity")
@EnableJpaRepositories(basePackages = "com.example.producthexagonal.repository")
@ComponentScan(basePackages = {
		"com.example.producthexagonal",         // para asegurar que application/domain también se escanean
		"com.example.producthexagonal.adapter"  // si tienes adapters en infra
})
public class BarcodehubApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarcodehubApplication.class, args);
	}

}
