package com.example.verduleria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//cuando cree el proyecto, cambiar la version de JDK a 17
@SpringBootApplication
public class VerduleriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerduleriaApplication.class, args);
	}

}
