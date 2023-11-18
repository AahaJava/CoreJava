package com.ahk.basics.java8.stream_api;

import com.ahk.basics.java8.stream_api.utils.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Assignment {

    public static void main(String[] args) {
        assignment();
    }

    private static void assignment() {
//
        System.out.println("1.\tDisplay the fruit names of low calories fruits i.e. calories < 100 sorted in descending order of calories.\n");
        List<Fruit> fruitList = TestData.getAllFruits();
        List<String> filterList = fruitList.stream().filter(fruit -> fruit.getCalories() < 100).sorted(Comparator.comparing(Fruit::getName).reversed()).map(Fruit::getName).collect(Collectors.toList());
        System.out.println(filterList);
        System.out.println("/////////////////////////////");


//        2.	Display color wise list of fruits.
        System.out.println("2.	Display color wise list of fruits.");
        fruitList = TestData.getAllFruits();
        Map<String, List<String>> filterList2 = fruitList.stream().collect(Collectors.groupingBy(Fruit::getColor, Collectors.mapping(Fruit::getName, Collectors.toList())));
        System.out.println(filterList2);
        System.out.println("/////////////////////////////");

// 3. Display only RED color fruits sorted as per their price in ascending order.
        System.out.println("\nRED color fruits sorted : \n");
        fruitList.stream().filter((Fruit fruit) -> fruit.getColor().equals("Red"))
                .sorted(Comparator.comparing(Fruit::getPrice)).forEach((Fruit fruit)-> System.out.println(fruit.getName()));


        List<News> listNews = TestData.getAllNews();

        // 4. Find out how many times the word 'budget' arrived in user comments of all news. Assume that �budget� word has arrived maximum once in a given user comment.

        System.out.println("/////////////////////////////");

        long count = listNews.stream().filter((News news)-> news.getComment().contains("budget")).count();
        System.out.println("\n'budget' arrived in user comments of all news : \n"+count);

        System.out.println("/////////////////////////////");

        List<Transaction> listTransactions = TestData.getAllTransactions();
        // 5. Find all transactions in the year 2011 and sort them by value (small to high)..
        System.out.println("\ntransactions in the year 2011 : \n");

        List<Transaction> filterSortTrans =  listTransactions.stream().filter((Transaction trns)-> trns.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(filterSortTrans);

        System.out.println("/////////////////////////////");

        //What are all the unique cities where the traders work
        System.out.println("\nunique cities where the traders work : \n");
        List<String> filterCityList = listTransactions.stream().map((Transaction t)-> t.getTrader().getCity()).distinct().collect(Collectors.toList());
        System.out.println(filterCityList);

        System.out.println("/////////////////////////////");
        // Find all traders from Pune and sort them by name.
        System.out.println("\ntraders from Pune and sort them by name : \n");
        List<Trader> filteTraderList = listTransactions.stream().filter((Transaction t)-> t.getTrader().getCity().equals("Pune")).sorted(Comparator.comparing((Transaction t) -> t.getTrader().getName())).map((Transaction t)->t.getTrader()).collect(Collectors.toList());
        System.out.println(filteTraderList);


        System.out.println("/////////////////////////////");
        // Return a string of all traders� names sorted alphabetically.
        System.out.println("\nall traders� names sorted alphabetically : \n");
        String allTraders = listTransactions.stream().map((Transaction t)-> t.getTrader().getName()).sorted().collect(Collectors.joining(","));
        System.out.println(allTraders);

        System.out.println("/////////////////////////////");
        // Are any traders based in Indore?
        System.out.println("\nAre any traders based in Indore : \n");
        Optional<Transaction> filterTrader =  listTransactions.stream().filter((Transaction t)-> t.getTrader().city.equals("Indore")).findAny();
        System.out.println("Are any traders based in Indore : "+filterTrader.isPresent());

        System.out.println("/////////////////////////////");
        // Print all transactions values from the traders living in Delhi.
        System.out.println("\ntransactions values from the traders living in Delhi : \n");
        List<Integer> filteValueList = listTransactions.stream().filter((Transaction t)-> t.getTrader().getCity().equals("Delhi")).map((Transaction t)-> t.getValue()).collect(Collectors.toList());
        System.out.println(filteValueList);


        System.out.println("/////////////////////////////");
        // What�s the highest value of all the transactions?
        System.out.println("\nhighest value of all the transactions : \n");
        Optional<Transaction> value = listTransactions.stream().collect(Collectors.maxBy(Comparator.comparing(Transaction::getValue)));
        System.out.println(value.get().getValue());

        System.out.println("/////////////////////////////");
        // Find the transaction with the smallest value.
        System.out.println("\ntransaction with the smallest value : \n");
        Optional<Integer> smallValue = listTransactions.stream().map(Transaction::getValue).reduce(Integer:: min);
        System.out.println(smallValue.get());

        System.out.println("/////////////////////////////");
        // Print first 15 prime numbers.
        System.out.println("\nfirst 15 prime numbers : \n");

        Stream.iterate(2, (n)->n+1).
                filter((n)-> {
                    for(int i=2;i<n;i++) {
                        if(n%i==0)
                            return false;
                    }
                    return true;
                }).
                limit(15).
                forEach(System.out::println);

        System.out.println("/////////////////////////////");
        // Print all high calories Fruits(Calorie > 200) using partitioning.
        System.out.println("\nall high calories Fruits(Calorie > 200) using partitioning : \n");
        Map<Boolean, List<Fruit>> fruitsMap = fruitList.stream().collect(Collectors.partitioningBy((Fruit f)-> f.getCalories() > 200));
        System.out.println(fruitsMap.get(true));

        // Find out the newsId which has received maximum comments.
        System.out.println("/////////////////////////////");
        System.out.println("\nnewsId which has received maximum comments : \n");
        Map.Entry<Integer, Long> mapId =  listNews.stream().collect(Collectors.groupingBy(News:: getNewsId, Collectors.counting())).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();

        System.out.println(mapId.getKey());



        // Display commentByUser wise number of comments.
        System.out.println("/////////////////////////////");
        System.out.println("\ncommentByUser wise number of comments : \n");
        Map<String, Long> commentMap= listNews.stream().collect(Collectors.groupingBy(News:: getCommentByUser, Collectors.counting()));

        System.out.println(commentMap);


        // Find out which user has posted maximum comments.
        System.out.println("/////////////////////////////");
        System.out.println("\nwhich user has posted maximum comments : \n");
        Map.Entry<String, Long> commentMaps= listNews.stream().collect(Collectors.groupingBy(News:: getCommentByUser, Collectors.counting())).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get();
        System.out.println(commentMaps.getKey());
    }


}
