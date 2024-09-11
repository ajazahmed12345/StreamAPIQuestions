package org.example;

public class Student {
    String name;
    int grade;

    Student(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
