package com.pl.df.examplewebfluxrsocket;

import lombok.Data;

@Data
public class ObjectMessage {

    private int number;
    private String clientMessage;
    private String serverMessage;

}
