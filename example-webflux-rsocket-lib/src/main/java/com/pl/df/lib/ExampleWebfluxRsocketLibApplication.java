package com.pl.df.lib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pl.df.lib")
public class ExampleWebfluxRsocketLibApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleWebfluxRsocketLibApplication.class, args);
	}

}
