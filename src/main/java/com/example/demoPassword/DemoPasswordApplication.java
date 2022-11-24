package com.example.demoPassword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demoPassword.*")
@EnableJpaAuditing
public class DemoPasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoPasswordApplication.class, args);
	}

}
