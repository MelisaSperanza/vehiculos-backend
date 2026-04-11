package com.rvsales.vehiculos_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.rvsales.vehiculos_app.model")
@EnableJpaRepositories("com.rvsales.vehiculos_app")
public class VehiculosAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiculosAppApplication.class, args);
	}

}



