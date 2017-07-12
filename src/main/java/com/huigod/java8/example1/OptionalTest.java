package com.huigod.java8.example1;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null);

        if(optional.isPresent()) {
            System.out.println(optional.get());
        }
        optional.ifPresent(System.out::println); //recommend way
        System.out.println("-------");


        System.out.println(optional.orElse("world"));
        System.out.println("---------");

        System.out.println(optional.orElseGet(() -> "hello world"));



    }
}
