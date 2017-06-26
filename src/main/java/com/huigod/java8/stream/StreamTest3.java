package com.huigod.java8.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest3 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "helloworld");

        //joining
//        String str = stream.collect(Collectors.joining()).toString();
//        System.out.println(str);

        //counting ??????????
//        long count = stream.collect(Collectors.counting());
//        System.out.println(count);

        //groupby
        stream.collect(Collectors.groupingBy(item -> item)).forEach((item1, item2) ->{
            System.out.println(item1);
            System.out.println(item2);
        });
    }
}
