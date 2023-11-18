package com.ahk.basics.java8.stream_api.groupby;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class GroupByTest {

    public static void main(String[] args) {
        groupByTest();
    }

    private static void groupByTest() {

        List<Employee> list = Arrays.asList(new Employee(100, 1,"Asif", 100000),
                new Employee(101, 3,"Preetam", 40000),
                new Employee(102, 3, "Sudipta", 60000),
                new Employee(103, 4,"Arif", 25000),
                new Employee(104, 4,"Thapas", 20000)
        );

        Map<Integer, Optional<Employee>> collect =
                list.stream().collect(
                        Collectors.groupingBy(
                                Employee::getDeptId,
                                Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))
                        )
                );

        System.out.println("Group Salary : "+ collect);
    }
}
