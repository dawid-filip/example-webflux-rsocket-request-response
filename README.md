## example-webflux-rsocket-request-response
Simple example of [RSocket](https://docs.spring.io/spring-framework/docs/current/reference/html/rsocket.html) *server* & *client* implementation with conjunction of [WebFlux](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html).

## How to run and test?
Follow steps in order:
1. Build `example-webflux-rsocket-lib` module and then,
2. Run `example-webflux-rsocket-server` module, 
3. Run `example-webflux-rsocket-client` module.

Once `server` and `client` are up and running you should see similar logs to this below for:
<details><summary>client</summary>

```
2022-11-12 21:19:39.824  INFO 6692 --- [           main] com.pl.df.client.ClientController        : Sending [The 1st message 1] message to server.<br>
2022-11-12 21:19:39.879  INFO 6692 --- [actor-tcp-nio-2] com.pl.df.client.ClientController        : Received [ServerMessage and The 1st message 1!] message from server.
```

</details>
<details><summary>server</summary>

```
2022-11-12 21:19:39.861  INFO 5192 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Received [The 1st message 1] message from client.
2022-11-12 21:19:39.861  INFO 5192 --- [ctor-http-nio-3] com.pl.df.server.ServerController        : Producing [ServerMessage and The 1st message 1!] massage back to client.
```
</details>

## Client API.

Following APIs are exposed:
1. GET [http://localhost:8082/client/send/message/{message}](http://localhost:8082/client/send/message/{message}).

When requesting http://localhost:8082/client/send/message/john` resource expect results similar as presented below:
<details><summary>client</summary>

```
2022-11-12 21:38:08.345  INFO 8048 --- [ctor-http-nio-3] com.pl.df.client.ClientController        : Sending [john 2] message to server.
2022-11-12 21:38:08.357  INFO 8048 --- [actor-tcp-nio-2] com.pl.df.client.ClientController        : Received [ServerMessage and john 2!] message from server.
```

</details>
<details><summary>server</summary>

```
2022-11-12 21:38:08.355  INFO 5192 --- [ctor-http-nio-4] com.pl.df.server.ServerController        : Received [john 2] message from client.
2022-11-12 21:38:08.356  INFO 5192 --- [ctor-http-nio-4] com.pl.df.server.ServerController        : Producing [ServerMessage and john 2!] massage back to client.
```

</details>

2. GET [http://localhost:8082/client/send/object-message/{message}](http://localhost:8082/client/send/object-message/{message}).
When requesting http://localhost:8082/client/send/object-message/john` resource expect results similar as presented below:
<details><summary>client</summary>

```
2022-11-12 21:39:33.113  INFO 8048 --- [ctor-http-nio-3] com.pl.df.client.ClientController        : Sending [ObjectMessage(number=3, clientMessage=john, serverMessage=null)] object-message to server.
2022-11-12 21:39:33.191  INFO 8048 --- [actor-tcp-nio-2] com.pl.df.client.ClientController        : Received [ObjectMessage(number=3, clientMessage=john, serverMessage=john 3)] object-message from server.
```

</details>
<details><summary>server</summary>

```
2022-11-12 21:39:33.180  INFO 5192 --- [ctor-http-nio-4] com.pl.df.server.ServerController        : Received [ObjectMessage(number=3, clientMessage=john, serverMessage=null)] object-message from client.
2022-11-12 21:39:33.180  INFO 5192 --- [ctor-http-nio-4] com.pl.df.server.ServerController        : Producing [ObjectMessage(number=3, clientMessage=john, serverMessage=john 3)] object-message back to client.
```

</details>

## Requirements
JDK 17 or higher.