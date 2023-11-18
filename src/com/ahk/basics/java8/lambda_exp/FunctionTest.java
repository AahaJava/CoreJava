package com.ahk.basics.java8.lambda_exp;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {

        functionTest();
    }

    private static void functionTest() {


        Function<Integer, String> function = (a) -> a < 40 ? "FAIL" : "PASS";
        System.out.println(function.apply(45));
        System.out.println(function.apply(30));

        Function<Integer, Integer> func_1 = x -> x +1;
        Function<Integer, Integer> func_2 = x -> x * 2;
        Function<Integer, Integer> func_3 = func_1.andThen(func_2);
        int result = func_3.apply(1);
        System.out.println(result);

        Function<Integer, Integer> func_4 = func_1.compose(func_2);
        int result2 = func_4.apply(1);
        System.out.println(result2);
    }
}
