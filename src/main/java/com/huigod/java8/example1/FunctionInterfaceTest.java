package com.huigod.java8.example1;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

//does not ount toward the interface's abstract method count since any implementation of the interface will have an implementation from or elsewhere
@FunctionalInterface
interface  MyInterface {

    void test();

    String toString();
}

public class FunctionInterfaceTest {

    public void myTest(MyInterface myInterface) {
        System.out.println("1");
        myInterface.test();
        System.out.println("2");
    }

    public static void main(String[] args) throws InterruptedException {

//        lamada expression replace a FunctionInterface
        FunctionInterfaceTest functionInterfaceTest = new FunctionInterfaceTest();
        functionInterfaceTest.myTest(() -> System.out.println("mytest"));

//        sort
        List<String> list1 = Arrays.asList("nihao", "hello", "world", "welcome");
        Collections.sort(list1, (item1, item2) -> item1.length() - item2.length());

//        thread
        Runnable r1 = () -> System.out.println("invoke run!");
        Thread thread = new Thread(r1);
        thread.start();

//        method reference replace a FunctionInterface
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

//        constructor method reference replace a FunctionInterface
        LinkedList<String> resultList = list.stream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println("--------------------------------------------");
        MyInterface myInterface = () -> {
            System.out.println("hello");
        };

//        Lamada is Object in java and must be attached with functionInterface,But it is function in python,scala,kotlin...
        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);
    }



}
