package com.example.magicofbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.magicofbooks")
public class MagicofbooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicofbooksApplication.class, args);
	}

}
