package com.huigod.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) {
        Stream stream1 = Stream.of("hello", "world", "hello world");

        String[] myArray = new String[]{"hello", "world", "hello world"};
        Stream stream2 = Stream.of(myArray);
        Stream stream3 = Arrays.stream(myArray);

        List<String> list = Arrays.asList(myArray);
        Stream stream4 = list.stream();

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(list2.stream().map(i -> 2 * i).reduce(0, Integer::sum));
    }

}
