package com.pl.df.examplewebfluxrsocket;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ObjectMessage {

    private int number;
    private String clientMessage;
    private String serverMessage;

}
