package com.juwoong.reviewforme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ReviewForMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewForMeApplication.class, args);
	}
}
