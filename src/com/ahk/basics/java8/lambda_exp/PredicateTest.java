package com.ahk.basics.java8.lambda_exp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {

        predicateTest();
    }

    private static void predicateTest() {

        List<String> list = Arrays.asList("java", "", "kal");

        Predicate<String> nonEmptyPredicate = (String s) -> !s.isEmpty();

        System.out.println("List : "+filterNonEmptyData(list, nonEmptyPredicate));

    }

    private static List<String> filterNonEmptyData(List<String> list, Predicate<String> nonEmptyPredicate) {

        List<String> listString = new ArrayList<>();

        for (String str:list) {

            if(nonEmptyPredicate.test(str)){
                listString.add(str);
            }
        }

        return listString;
    }
}