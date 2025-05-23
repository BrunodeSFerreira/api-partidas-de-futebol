package com.meli.api_futebol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ApiFutebolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFutebolApplication.class, args);
	}

}
