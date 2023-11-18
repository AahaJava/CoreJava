package com.ahk.basics.java8.stream_api.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class FlatmapTest {

    public static void main(String[] args) {
        flatmapTest();
    }

    private static void flatmapTest() {

        List<Employee> uiEmployee = Arrays.asList(new Employee(100, "Asif", 100000),
                new Employee(101, "Preetam", 40000),
                new Employee(102, "Sudipta", 60000),
                new Employee(103, "Arif", 25000),
                new Employee(104, "Thapas", 20000)
                );

        List<Employee> mobileEmployee = Arrays.asList(new Employee(105, "Asif", 110000),
                new Employee(106, "Ajay", 40000),
                new Employee(107, "Preeti", 60000),
                new Employee(108, "Omvir", 25000),
                new Employee(109, "Rahul", 20000)
                );

        List<Employee> backendEmployee = Arrays.asList(
                new Employee(110, "Priyanka", 400000),
                new Employee(111, "Yash", 60000),
                new Employee(112, "Madhuri", 250000),
                new Employee(113, "Gourang", 20000),
                new Employee(114, "Nikhil", 100000)
                );

        List<Department> departments = Arrays.asList(

                new Department(1, "Graphics", uiEmployee),
                new Department(2, "Mobile", mobileEmployee),
                new Department(3, "Backend", backendEmployee)
        );

        // highest salary of dept 1

        OptionalDouble maxSalaryDept = departments.stream()
                .filter(department -> department.getDeptId() == 1)
                .flatMap(department -> department.getEmployees().stream())
                .mapToDouble(Employee::getSalary)
                .max();
        System.out.println("Max Salary :"+ maxSalaryDept.getAsDouble());

        //Highest Salary in All employee
        OptionalDouble maxSalary = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .mapToDouble(Employee::getSalary)
                .max();
        System.out.println("Max Salary in All Employee :"+ maxSalary.getAsDouble());

    }
}
