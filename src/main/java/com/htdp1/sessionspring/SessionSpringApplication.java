package com.htdp1.sessionspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SessionSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionSpringApplication.class, args);
	}

}
