package com.example.java;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    static List<? extends Animal> acceptAnimal(List<? super Animal> animal){



        List<Animal> d = new ArrayList<Animal>();
        d.add(new Dog());
        d.add(new Cat());
        return d;
    }

    static List<Animal> acceptAnimal1(List<Animal> animal){


        List<Animal> d = new ArrayList<Animal>();
        d.add(new Dog());
        //d.add(new Cat());
        return d;
    }

    static <T> List<T> listOfDuplicates(T a, int length)
    {
        if(length < 1)
        {
            return new ArrayList<T>();
        }
        else
        {
           List<T> l = listOfDuplicates(a, length -1);
           l.add(a);
           return l;
        }
    }

    public static void main(String[] args) {

        List<Animal> ani = new ArrayList<Animal>();
        List<? extends Animal> animal =  acceptAnimal(ani);
        animal.forEach( e -> System.out.println(e));

        //acceptAnimal1(new ArrayList<Dog>());
        System.out.println(listOfDuplicates(3, 3));
        System.out.println(listOfDuplicates("Yes", 3));

    }
}


abstract class Animal{

}

class Dog extends  Animal{

}

class Cat extends Animal {

}
