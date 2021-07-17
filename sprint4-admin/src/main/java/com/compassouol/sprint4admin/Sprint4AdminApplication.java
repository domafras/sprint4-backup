package com.compassouol.sprint4admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class Sprint4AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprint4AdminApplication.class, args);
	}

}
