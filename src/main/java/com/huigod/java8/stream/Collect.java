package com.huigod.java8.stream;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Collect {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        //summary  reducing
        System.out.println("summary:");
        students.stream().collect(Collectors.minBy(Comparator.comparingInt(Student::getScore))).ifPresent(System.out::println);
        students.stream().collect(Collectors.averagingInt(Student::getScore));
        students.stream().collect(Collectors.counting());
        students.stream().collect(Collectors.summingInt(Student::getAge));

        //joining
        System.out.println("joining:");
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining()));
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(", ")));
        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(", ", "<begin>", "<end>")));

        //groupby
        System.out.println("groupby:");
        System.out.println(students.stream().collect(Collectors.groupingBy(Student::getName)));
        System.out.println(students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting())));
        System.out.println(students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore))));
        //Map<Integer, Map<String, List<Student>>>
        System.out.println(students.stream().collect(Collectors.groupingBy(Student::getScore,Collectors.groupingBy(Student::getName))));

        //partition
        System.out.println("partition:");
        System.out.println(students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90)));

    }
}
