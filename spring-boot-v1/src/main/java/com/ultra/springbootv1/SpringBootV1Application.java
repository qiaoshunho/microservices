package com.ultra.springbootv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@SpringBootApplication
public class SpringBootV1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootV1Application.class, args);
	}

}

