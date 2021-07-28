package com.example.java;

import java.io.IOException;
import java.util.TreeMap;
import java.util.function.Function;

public class Exception {

    public static void main(String[] a)
    {
        String s = callCloseable(new Closeable(),  (cl) -> cl.read("Read"));
        System.out.println(s);
    }

    public static <A extends Closeable, B>  B callCloseable(A a, Function<A,B> fun) {
        try
        {
            B s = fun.apply(a);
            return s;
        }finally {
            a.close();
        }

    }
}


class Closeable implements AutoCloseable {

    public String read(String a) {
        if(a == "Read") return "Read"; else throw new NullPointerException();
    }

    @Override
    public void close()  {
        throw new NullPointerException();
    }
}