package com.pl.df.lib;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ObjectMessage {

    private int number;
    private String clientMessage;
    private String serverMessage;

}
