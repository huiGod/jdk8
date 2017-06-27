package com.huigod.java8.stream;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest3 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "helloworld", "hello");

        //joining
        String str = stream.collect(Collectors.joining()).toString();
        System.out.println(str);

        //counting
        long count = stream.collect(Collectors.counting());
        System.out.println(count);


        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        //groupby
        Map<String,List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));
        Map<String, Long> map1 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        Map<String, Double> map2 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));

        //partition
        Map<Boolean, List<Student>> map3 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));

        System.out.println(map);
    }
}
