package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo1 {
    static List<String> names = Arrays.asList("Ajaz", "Ahmed", "Khan", "Yusuf");

    static void listForEach(){
        for(String s : names) {
            System.out.println(s);
        }

        names.forEach((s) -> System.out.println(s));

        List<String> strings = Arrays.asList("one", "two", "three", "four");
        AtomicInteger count = new AtomicInteger();
        strings.forEach(name -> {
            System.out.println(name);
            System.out.println(count.getAndIncrement());
        });
    }

    static void replaceAll(){


        names.replaceAll(s->s+" check");
        names.forEach(System.out::println);
        // Create a mutable copy of the list since names is immutable
        List<String> modifiableNames = new ArrayList<>(names);

        modifiableNames.replaceAll(s -> s + " updated");

        modifiableNames.forEach(System.out::println);
    }

    public static void main(String[] args) {
        listForEach();
        replaceAll();
    }
}
