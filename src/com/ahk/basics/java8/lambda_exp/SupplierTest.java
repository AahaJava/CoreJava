package com.ahk.basics.java8.lambda_exp;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {

        supplierTest();
    }

    private static void supplierTest() {

        Random random = new Random();
        Supplier<Integer> supplier = ()-> random.nextInt(100);

        printGrade(supplier);
    }

    private static void printGrade(Supplier<Integer> supplier) {

        int marks = supplier.get();

        if(marks < 100 && marks > 80){
            System.out.println(marks+ " Grade is A");
        }else if(marks < 80 && marks > 60){
            System.out.println(marks+ " Grade is B");
        }else if(marks < 60 && marks > 40){
            System.out.println(marks+ " Grade is C");
        }else if(marks < 40 && marks > 35){
            System.out.println(marks+ " Grade is D");
        }else{
            System.out.println(marks+ " Fail");
        }

    }
}
