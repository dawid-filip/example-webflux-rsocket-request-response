package com.pl.df.server;

import com.pl.df.lib.Util;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleWebfluxRsocketServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleWebfluxRsocketServerApplication.class, args);
		Util.waitTillKeyAction();
	}

}
