package com.compassouol.sprint4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Sprint4Application {

	public static void main(String[] args) {
		SpringApplication.run(Sprint4Application.class, args);
	}

}
