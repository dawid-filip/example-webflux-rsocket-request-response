package com.pl.df.examplewebfluxrsocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

@Configuration
public class ClientConfiguration {

    @Bean
    public ServerRSSocketProperties myRSSocketProperties() {
        return new ServerRSSocketProperties();
    }

    @Bean
    public RSocketRequester rSocketRequester(RSocketRequester.Builder builder,
                                             ServerRSSocketProperties serverRSSocketProperties) {
        return builder.connectTcp(
                    serverRSSocketProperties.getAddress(),
                    serverRSSocketProperties.getPort())
                .block();
    }

}
