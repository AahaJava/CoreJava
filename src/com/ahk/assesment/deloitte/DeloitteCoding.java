package com.ahk.assesment.deloitte;

import com.ahk.basics.java8.stream_api.groupby.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DeloitteCoding {

    public static void main(String[] args) {
        employeeOperations();
        sumOfListElement();
    }

    private static void sumOfListElement() {

        List<Integer> list = Arrays.asList(1, 3, 5, 6, 7, 89, 3);

        int summ = list.stream().reduce(Integer::sum).get();
        System.out.println("Sum : " + summ);
    }

    private static void employeeOperations() {
        List<Employee> list = Arrays.asList(new Employee(100, 1, "Asif", 100000),
                new Employee(101, 3, "Preetam", 40000),
                new Employee(102, 3, "Sudipta", 64000),
                new Employee(103, 4, "Arif", 25000),
                new Employee(104, 4, "Thapas", 22000),
                new Employee(105, 3, "Abrar", 60000),
                new Employee(106, 4, "Hammad", 27000),
                new Employee(107, 4, "Ayeza", 21000)
        );

        //Sort employees based on their salary

        List<Employee> sortedList = list.stream().sorted((o1, o2) -> o2.getSalary() - o1.getSalary()).collect(Collectors.toList());
        System.out.println("Sorted List : " + sortedList);

        // Top 3 salaried employees

        List<Employee> top3List = list.stream().
                sorted((o1, o2) -> o2.getSalary() - o1.getSalary())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Top 3 Salaried Salary Employees List : " + top3List);

        //Fetch all emp having salary less than third-highest salary
        List<Employee> empLessSalaryThanThirdHighestList = list.stream().
                sorted((o1, o2) -> o2.getSalary() - o1.getSalary())
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("Emp having salary less than third-highest salary : " + empLessSalaryThanThirdHighestList);
    }

}
