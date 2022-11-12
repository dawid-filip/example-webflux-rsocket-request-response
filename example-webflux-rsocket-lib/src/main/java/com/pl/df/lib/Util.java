package com.pl.df.lib;

import lombok.SneakyThrows;

public class Util {

    @SneakyThrows
    public static void waitTillKeyAction() {
        System.in.read();
    }

}
