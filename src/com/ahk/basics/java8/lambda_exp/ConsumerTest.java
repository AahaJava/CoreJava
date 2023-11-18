package com.ahk.basics.java8.lambda_exp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerTest {

    public static void main(String[] args) {

        consumerTest();
    }

    private static void consumerTest() {

        List<String> list = Arrays.asList("java", "Test", "kal");

        Consumer<String> consumerOwn = (String s) -> System.out.println(s);

        printListData(list, consumerOwn);

    }

    private static void printListData(List<String> list, Consumer<String> consumerOwn) {

        for (String s : list) {
            consumerOwn.accept(s);
        }


    }

}