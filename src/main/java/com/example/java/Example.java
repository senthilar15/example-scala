package com.example.java;

import java.util.function.BiFunction;

public class Example {

    private static int factorial(int f, int acc)
    {
        if(f == 1) return acc;
        else{
           return factorial(f-1, f * acc);
        }
    }


    private static BiFunction<String, String, String> urlBuilder(boolean ssl, String domainName)
    {
        String scheme = ssl ? "https://" : "http://";
        return (endPoint, query) -> scheme+domainName+"/"+endPoint+"?"+query;
    }

    private static int foldLeft(int acc, int element)
    {
        return acc + element;
    }
    private static void fold()
    {
        int init =0;
        for(int i = 1; i < 5; i++)
        {
            init = foldLeft(init, i);
        }
    }


    public static void main(String[] args) {
       BiFunction<String, String, String> getUrl = urlBuilder(true, "google");
       System.out.println(getUrl.apply("query","1=1"));
       System.out.println(factorial(3, 1));
       Child c = new Child("Child");
    }
}

class Parent{
    Parent(String name)
    {
        System.out.println("Parent");
    }

}
class Child extends  Parent {
    private String name;
    Child(String name)
    {
        super(name);
        this.name = name;
    }
}