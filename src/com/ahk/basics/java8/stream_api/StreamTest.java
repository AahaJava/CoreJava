package com.ahk.basics.java8.stream_api;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {

        filterOperation();
        arrayOrListOperationUsingStream();
        arrayOrListStringOperationUsingStream();

    }

    private static void filterOperation() {

    }

    private static void arrayOrListOperationUsingStream() {
        List<Integer> list = Arrays.asList(2, 4, 5, 7, 8, 6, 4, 3, 2, 5, 7, 8);

        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted List " + sortedList);
        List<Integer> distinctList = list.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct List " + distinctList);

        List<Integer> evenList = list.stream().filter(i -> i % 2 == 0).limit(4).collect(Collectors.toList());
        System.out.println("Even List " + evenList);

        //Optional<Integer> maxNumber = list.stream().max(Integer::compare);

        Comparator<Integer> comparator = (x, y) -> ((x < y) ? -1 : ((x == y) ? 0 : 1));

        Optional<Integer> maxNumber = list.stream().max(comparator);
        System.out.println("Max Num " + maxNumber.get());

        Optional<Integer> minNumber = list.stream().min(Integer::compare);
        System.out.println("Min Num " + minNumber.get());

        Optional<Integer> sum = list.stream().reduce(Integer::sum);
        System.out.println("Sum of Array " + sum.get());

        double average = list.stream().mapToDouble(a -> a).average().getAsDouble();
        System.out.println("Average Of Array " + average);

    }

    private static void arrayOrListStringOperationUsingStream() {
        List<String> list = Arrays.asList("Asdj", "Gjjj", "Babar","Babar", "Chjshdf", "KJLK", "HDKS");

        List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted List " + sortedList);
        List<String> distinctList = list.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct List " + distinctList);

        List<String> evenList = list.stream().filter(i -> !i.isEmpty()).limit(4).collect(Collectors.toList());
        System.out.println("Non Empty List " + evenList);

        Optional<String> maxNumber = list.stream().max(Comparator.comparing(String::length));

        System.out.println("Max Length String " + maxNumber.get());

        Optional<String> minNumber = list.stream().min(Comparator.comparing(String::length));
        System.out.println("Min Length String " + minNumber.get());

        Map<String, Long> map= list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(" Grouping Map "+ map);

        Map<String, Integer> map2= list.stream().distinct().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(" Length Map "+ map2);

        Map<String, Integer> map3= list.stream().collect(Collectors.toMap(Function.identity(), String::length, (e1, e2)-> e1, LinkedHashMap::new));
        System.out.println(" Length Map "+ map3);

        Map<String, Integer> map4= list.stream().distinct().collect(Collectors.toMap(s->s, String::length));
        System.out.println(" Length Map "+ map4);

        //        Optional<Integer> sum = list.stream().reduce(Integer::sum);
//        System.out.println("Sum of Array "+ sum.get());

    }
}
