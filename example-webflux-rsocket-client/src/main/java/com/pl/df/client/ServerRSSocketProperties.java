package com.pl.df.client;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class ServerRSSocketProperties {
    private final String address = "localhost";
    private final int port = 8181;
}
