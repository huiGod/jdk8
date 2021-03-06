package com.huigod.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MapAndFlatMap {
    public static void main(String[] args) {

        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        List<String> studentNames = students.stream()
                .map(Student::getName)
                .collect(toList());

        //string length
        List<String> words1 = Arrays.asList("Java 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words1.stream()
                .map(String::length)
                .collect(toList());

        //student name length
        List<Integer> studentNamesLength = students.stream()
                .map(Student::getName)
                .map(String::length)
                .collect(toList());

        //["Hello","World"]    //["H","e","l", "o","W","r","d"]
        String[] words = new String[]{"Hello", "World"};
        List<String[]> list = Stream.of(words)
                .map(word -> word.split(""))   //Stream<String[]>   //Stream<String>
                .distinct()
                .collect(toList());

        //Arrays.stream
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);

        Stream.of(words)
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());

        //the flatMap method lets you replace each value of a stream with another stream and then concatenates all the generated streams into a single stream
        List<String> uniqueCharacters = Stream.of(words)
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }













}
