package com.ahk.basics.java8.stream_api.map;

import com.ahk.basics.java8.stream_api.filter.Family;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MapTest {

    public static void main(String[] args) {

        mapOperation();
        customOperationMap();

    }

    private static void customOperationMap() {

        List<Product> list = Arrays.asList(
                new Product(1, "Soap", "4.1","Available", 92),
                new Product(3, "Colgate", "4.2","Available", 45),
                new Product(5, "Sanitizer", "4.3","Out Of Stock", 50),
                new Product(9, "Surf", "4.4","Available", 70),
                new Product(8, "Shampoo", "4.5","Out Of Stock", 4)
        );

        List<ProductBasic> productBasicList = list.stream().map(product -> {
            return new ProductBasic(product.getName(), product.getAvailability(), product.getPrice());
        }).collect(Collectors.toList());

        System.out.println("Product Basics "+productBasicList);
    }

    private static void mapOperation() {

        List<Integer> list = Arrays.asList(10, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> mappedList = list.stream().map(i -> i * 5).collect(Collectors.toList());
        System.out.println("Mapped List : " + mappedList);

        Function<Integer,Integer> fun1 = (i) ->
        {
            System.out.println("Fun 1 executed");
            return i * 2;
        };
        Function<Integer, Integer> fun2 = (i) -> {
            System.out.println("Fun 2 executed");

            return i + 3;
        };

        //List<Integer> transformedList = list.stream().map(fun1.andThen(fun2)).collect(Collectors.toList());
        List<Integer> transformedList = list.stream().map(fun1.compose(fun2)).collect(Collectors.toList());
        System.out.println("Transformed List : " + transformedList);
    }
}
