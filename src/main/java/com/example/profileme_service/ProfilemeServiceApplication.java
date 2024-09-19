package com.example.profileme_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ProfilemeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfilemeServiceApplication.class, args);
	}

}
