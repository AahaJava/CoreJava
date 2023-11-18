package com.ahk.basics.java8.lambda_exp;

interface Adding{
    int sum(int a, int b);
}
interface Display{
    void display();
}

interface Reference{
    MethodReference getMethodReference();
}
public class MethodReference {
    public static void main(String[] args) {
        staticMethodReferenceTest();
        instanceMethodReferenceTest();
        constructionReferenceTest();
    }

    MethodReference(){
        System.out.println("Constructor Invoked");
    }

    private static void staticMethodReferenceTest() {

        Adding x =  MethodReference::sumOf;
         int y = x.sum(5,8);
        System.out.println("Sum of 5, 8 is "+y);
    }

    public static int sumOf(int a, int b){
        return a+b;
    }



    private static void instanceMethodReferenceTest() {

        MethodReference ref = new MethodReference();
        Display display = ref::printM;
        display.display();
    }

    private void printM(){
        System.out.println("Statement 1");
        System.out.println("Statement 2");
        System.out.println("Statement 3");
    }

    private static void constructionReferenceTest() {

        Reference ref = MethodReference::new;
        MethodReference methodReference = ref.getMethodReference();
        methodReference.printM();
    }
}
