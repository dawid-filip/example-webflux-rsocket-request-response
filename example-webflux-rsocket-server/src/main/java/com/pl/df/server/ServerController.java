package com.pl.df.server;

import com.pl.df.lib.ObjectMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@Log4j2
public class ServerController {

    @MessageMapping("server-message")
    public Mono<String> serverRSocket(@Payload String message,
                                      @Headers Map<String, Object> headers) {
//        printHeaders(headers);
        return produceMessage(message);
    }

    private void printHeaders(Map<String, Object> headers) {
        log.info("------------------ Headers -------------------");
        headers.forEach((key, value) -> log.info("[" + key + '=' + value + "]"));
        log.info("----------------------------------------------");
    }

    private Mono<String> produceMessage(String message) {
        var produce = "ServerMessage and " + message + "!";
        log.info("Received [" + message + "] message from client.");
        log.info("Producing [" + produce + "] massage back to client.");
        return Mono.just(produce);
    }

    @MessageMapping("server-object-message")
    public Mono<ObjectMessage> serverRSocket(@Payload ObjectMessage objectMessage, @Headers Map<String, Object> headers) {
//        printHeaders(headers);
        return Mono.just(objectMessage)
                .map(message -> {
                    log.info("Received [" + message + "] object-message from client.");

                    message.setServerMessage(message.getClientMessage() + " " + message.getNumber());

                    log.info("Producing [" + message + "] object-message back to client.");
                    return message;
                });
    }

}
