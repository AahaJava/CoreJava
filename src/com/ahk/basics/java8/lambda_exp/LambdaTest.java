package com.ahk.basics.java8.lambda_exp;

import java.util.concurrent.Callable;

interface Addition{

    int add(int a, int b);
}

interface MessageService{

    //void message(String msg);
    String message(String msg);
}
public class LambdaTest {

    public static void main(String[] args) {

        lambdaSyntax();
    }

    private static void lambdaSyntax() {

        Addition lambda = (a, b) -> a + b;

        System.out.println("Addition : "+lambda.add(2,4));

//        MessageService messageService = (str)-> {
//            System.out.println(str);
//        };

        MessageService messageService = (str)-> {return "ds";};

        messageService.message("Hello Lambda");
    }
}
