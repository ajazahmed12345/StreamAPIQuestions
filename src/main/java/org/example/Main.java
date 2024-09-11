package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void numbersStartingWith1(){
        List<Integer> list = Arrays.asList(2, 1, 4, 3, 5, 6, 1, 17, 90, 1000);

        List<Integer> numsStartingWith1 = list.stream().filter(e -> e.toString().startsWith("1")).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(numsStartingWith1);
    }

    public static void groupNamesByTheirFirstLetterAndPrintThemWithTheirCount(){
        List<String> names = Arrays.asList("Alice", "Bob", "Billy", "Charlie", "Alina", "Elem", "Apple","Doggy");

        names.stream().collect(Collectors.groupingBy(e -> e.charAt(0), LinkedHashMap::new, Collectors.counting()))
                .entrySet().forEach(it -> System.out.println(it.getKey() + " : " + it.getValue()));
    }

    public static void printDuplicateNumbersIfItContainsCountGreaterThan1(){
        List<Integer> list = Arrays.asList(2, 1, 4, 3, 10,  5, 6, 6, 1, 1, 5, 90, 10);

        list.stream().collect(Collectors.groupingBy(e->e, Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue() > 1)
                .map(e->e.getKey()).forEach(e-> System.out.println(e));
    }

    public static void findAndPrintThePalindromeStringsFromList(){
        List<String> list = Arrays.asList("level", "hello", "radar", "deed", "world");

        list.stream().filter(str -> str.equals(new StringBuilder(str).reverse().toString()))
                .forEach(e-> System.out.println(e));
    }

    public static void mergeTwoSortedArrays(){
        int[] arr1 = {1, 3, 4, 7};
        int[] arr2 = {2, 4, 5, 6, 7, 9};

        int[] ans = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();

        System.out.println(Arrays.toString(ans));
    }

    public static void concatenateAndRemoveDuplicateStringsFromList(){
        List<String> list1 = Arrays.asList("apple", "banana", "orange");
        List<String> list2 = Arrays.asList("kiwi", "banana", "grapes", "orange");

        List<String> ans = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());

        System.out.println(ans);
    }

    public static void studentGradeClassificationAboveMarks70(){
        List<Student> students = Arrays.asList(
                new Student("Alice", 86),
                new Student("Bob", 70),
                new Student("Charlie", 67),
                new Student("David", 90)
        );

        Map<String, List<Student>> classifiedMap = students.stream().collect(Collectors.groupingBy(e->e.grade >= 70 ? "Pass" : "Fail"));
        System.out.println(classifiedMap);
    }

    public static void sortStringsInIncreasingOrderOfTheirLength(){
        List<String> list = Arrays.asList("Apple", "Mango", "a", "banana", "ugdefieagife", "Kiwi");

//        List<String> sortedList = list.stream().sorted((a, b) -> {
//            return (a.length() - b.length());
//        }).collect(Collectors.toList());

        List<String> sortedList = list.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        System.out.println(sortedList);
    }
    public static void main(String[] args) {

//        groupNamesByTheirFirstLetterAndPrintThemWithTheirCount();

//        printDuplicateNumbersIfItContainsCountGreaterThan1();

//        findAndPrintThePalindromeStringsFromList();

//        mergeTwoSortedArrays();

//        concatenateAndRemoveDuplicateStringsFromList();

//        studentGradeClassificationAboveMarks70();

        sortStringsInIncreasingOrderOfTheirLength();

    }
}