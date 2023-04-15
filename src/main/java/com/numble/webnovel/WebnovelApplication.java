package com.numble.webnovel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(exclude = {})
public class WebnovelApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebnovelApplication.class, args);

	}

}
