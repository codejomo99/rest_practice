package com.elice.jongmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JongminApplication {

	public static void main(String[] args) {
		SpringApplication.run(JongminApplication.class, args);
	}

}
