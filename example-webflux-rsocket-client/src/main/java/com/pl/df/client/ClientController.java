package com.pl.df.client;

import com.pl.df.lib.ObjectMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
@Log4j2
public class ClientController {

    private final RSocketRequester rSocketRequester;
    private static AtomicInteger number = new AtomicInteger(1);

    @GetMapping("/send/message/{message}")
    public Mono<String> rsocketMessage(@PathVariable("message") String message) {
        printAndCheckBasicRSocketData();

        final String requestMessage = message + " " + number.getAndIncrement();
        final String requestValue = "Sending [" + requestMessage + "] message to server.";
        log.info(requestValue);

        return this.rSocketRequester
                .route("server-message")
                .data(requestMessage)
                .retrieveMono(String.class)
                .map(responseMessage -> {
                    log.info("Received [" + responseMessage + "] message from server.");
                    return responseMessage;
                });
    }

    @GetMapping("/send/object-message/{message}")
    public Mono<ObjectMessage> rsocketObjectMessage(@PathVariable("message") String message) {
        printAndCheckBasicRSocketData();

        ObjectMessage objectMessage = new ObjectMessage(number.getAndIncrement(), message, null);
        final String requestValue = "Sending [" + objectMessage + "] object-message to server.";
        log.info(requestValue);

        return this.rSocketRequester
                .route("server-object-message")
                .data(objectMessage)
                .retrieveMono(ObjectMessage.class)
                .map(responseMessage -> {
                    log.info("Received [" + responseMessage + "] object-message from server.");
                    return responseMessage;
                });
    }

    // --- //

    private void throwExceptionWhenRSocketIsUnavailable() {
        var availability = this.rSocketRequester.rsocket().availability();

        if (availability == 0.0)    // 1.0 available | 0.0 unavailable
            throw new RuntimeException("The availability cannot be 0.0!");
    }
    private void printRSocketData() {
        log.info("the rsocket availability is: " + this.rSocketRequester.rsocket().availability());
        log.info("       the data mimeType is: " + this.rSocketRequester.dataMimeType());
        log.info("   the metadata mimeType is: " + this.rSocketRequester.metadataMimeType());
    }
    private void printAndCheckBasicRSocketData() {
        throwExceptionWhenRSocketIsUnavailable();
//        printRSocketData();
    }

}
