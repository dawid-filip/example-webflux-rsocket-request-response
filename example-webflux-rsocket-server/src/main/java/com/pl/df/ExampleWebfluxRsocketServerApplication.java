package com.pl.df.examplewebfluxrsocket;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleWebfluxRsocketServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleWebfluxRsocketServerApplication.class, args);
		waitTillKeyAction();
	}

	@SneakyThrows
	public static void waitTillKeyAction() {
		System.in.read();
	}

}
