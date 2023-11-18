package com.ahk.basics.java8.stream_api.filter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterTest {

    public static void main(String[] args) {

        filterOperation();
        filterOperationOnCustom();


    }

    private static void filterOperationOnCustom() {

        List<Family> list = Arrays.asList(
                new Family(4, 10000),
                new Family(2, 15000),
                new Family(6, 18000),
                new Family(9, 19000),
                new Family(5, 30000)
        );

        List<Family> filterListGt7 = list.stream().filter(family -> family.getMembers() >7 ).collect(Collectors.toList());
        System.out.println("Filter List : " + filterListGt7);

        List<Family> sortedList = list.stream().sorted(Comparator.comparing(Family::getSalary).reversed()).collect(Collectors.toList());
        System.out.println("Sorted List : " + sortedList);

    }

    private static void filterOperation() {

        List<Integer> list = Arrays.asList(10, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> filterList = list.stream().filter(i -> i > 5).collect(Collectors.toList());
        System.out.println("Filter List : " + filterList);

        // find number <6 and >3

        Predicate<Integer> filter1 = (i) -> i < 6;
        Predicate<Integer> filter2 = (i) -> i > 3;
        List<Integer> filterList2 = list.stream().filter(filter1.and(filter2)).collect(Collectors.toList());
        System.out.println("Filter List : " + filterList2);
    }
}
