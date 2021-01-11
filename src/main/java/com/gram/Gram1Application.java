package com.gram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gram.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Gram1Application {

	public static void main(String[] args) {
		SpringApplication.run(Gram1Application.class, args);
	}

}
