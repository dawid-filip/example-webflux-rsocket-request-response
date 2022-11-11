package com.pl.df.examplewebfluxrsocket;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class ExampleWebfluxRsocketClientApplication {

	private final ClientController clientController;

	@SneakyThrows
	public static void main(String[] args) {
		SpringApplication.run(ExampleWebfluxRsocketClientApplication.class, args);
		waitTillKeyAction();
	}

	@SneakyThrows
	public static void waitTillKeyAction() {
		System.in.read();
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReadyEvent() {
		this.clientController
				.rsocketMessage("The Test Message")
				.subscribe();
	}

}
