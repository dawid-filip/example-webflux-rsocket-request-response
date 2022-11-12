package com.pl.df.client;

import com.pl.df.lib.Util;
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
		Util.waitTillKeyAction();
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReadyEvent() {
		this.clientController
				.rsocketMessage(("The 1st message"))
				.subscribe();
	}

}
