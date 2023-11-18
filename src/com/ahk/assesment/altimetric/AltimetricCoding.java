package com.ahk.assesment.altimetric;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AltimetricCoding {
    public static void main(String[] args) {

        writePairOfNegativePositiveNumber();
        writeMapOfStringLengthFromListNumber();
    }

    private static void writePairOfNegativePositiveNumber() {
        List<String> list = Arrays.asList("Asdj", "Gjjj", "Babar","Babar", "Chjshdf", "KJLK", "HDKS");

        Map<String, Integer> map = list.stream().collect(Collectors.toMap(Function.identity(), String::length, (e1, e2)->e1, LinkedHashMap::new));
        System.out.println("Map with Length "+map);
    }

    private static void writeMapOfStringLengthFromListNumber() {
        int[] arr = { 1, -3, 2, 3, 6, -1 };
        //Output: -1 1 -3 3

        for (int i = 0; i <arr.length; i++) {

            for (int j = i; j <arr.length; j++) {

                if(arr[i]+arr[j] == 0){
                    System.out.print(arr[i] + " " + arr[j]);
                    break;
                }
            }
        }
    }
}
