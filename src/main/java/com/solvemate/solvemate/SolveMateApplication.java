package com.solvemate.solvemate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SolveMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolveMateApplication.class, args);
	}

}
