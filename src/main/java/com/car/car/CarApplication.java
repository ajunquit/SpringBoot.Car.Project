package com.car.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CarApplication {

	private static final Logger logger =
			LoggerFactory.getLogger(CarApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

}
