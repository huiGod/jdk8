package com.huigod.java8.example1;

import java.util.function.*;

public class BasicFunctionTest {
    public static void main(String[] args) {
        BasicFunctionTest test = new BasicFunctionTest();
        //supplier
        System.out.println("supplier: " + test.supplier(() -> 1));
        //consumer
        test.consumerTest(1, System.out::println);
        //function
        System.out.println("function: " + test.functionTest(1, value -> 2 * value));
        //predicate
        System.out.println("predicate: " + test.predicateTest(1, value -> value == 1));
        //BiFunction
        System.out.println("BiFunction：" + test.BiFunctionTest(1, 2, (value1, value2) -> value1 + value2));
        //BinaryOperator
        System.out.println("BinaryOperator minBy: " + test.BinaryOperatorTest(1, 2, BinaryOperator.minBy((value1 , value2) -> value1 - value2)));
//        System.out.println("BinaryOperator minBy: " + test.BinaryOperatorTest(1, 2, BinaryOperator.minBy(Comparator.comparingInt(value -> value))));
        //UnaryOperator
        System.out.println("UnaryOperator: " + test.UnaryOperationTest(1, value -> value * 2));
        System.out.println("UnaryOperator identity: " + test.UnaryOperationTest(1, UnaryOperator.identity()));
    }

    private int supplier(Supplier<Integer> supplier) {
        return supplier.get();
    }

    private void consumerTest(int a, Consumer<Integer> consumer) {
        consumer.accept(a);
    }

    private int functionTest(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    private boolean predicateTest(int a, Predicate<Integer> predicate) {
        return predicate.test(a);
    }

    private int BiFunctionTest(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    private int BinaryOperatorTest(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }

    private int UnaryOperationTest(int a, UnaryOperator<Integer> unaryOperator) {
        return unaryOperator.apply(a);
    }

}
