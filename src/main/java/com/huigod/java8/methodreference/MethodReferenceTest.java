package com.huigod.java8.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest {

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 50);
        Student student4 = new Student("zhaoliu", 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        //ClassName::StaticMethod
        students.sort((studentParam1, studentParam2) -> Student.compareStudentByScore(studentParam1, studentParam2));
        students.forEach(student -> System.out.println(student.getScore()));
        System.out.println("--------------------------------------");
        students.sort(Student::compareStudentByScore);
        students.forEach(student -> System.out.println(student.getScore()));

        //ObjectName::InstanceMethod
        students.sort((studentParam1, studentParam2) -> new StudentComparator().compareStudentByScore(studentParam1, studentParam2));
        students.forEach(student -> System.out.println(student.getScore()));
        System.out.println("--------------------------------------");
        students.sort(new StudentComparator()::compareStudentByScore);
        students.forEach(student -> System.out.println(student.getScore()));

        //ClassName::InstanceMethod(Comstructor method reference)
        students.sort(Student::compareByName);
        students.forEach(student -> System.out.println(student.getScore()));

        //ClassName::new
        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
        System.out.println(methodReferenceTest.getString(String::new));
        System.out.println(methodReferenceTest.getString2("test", String::new));
    }
}
