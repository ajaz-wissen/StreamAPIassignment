package org.example;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureCombineFuture {
    public static void main(String[] args) throws Exception {

        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> {
            return "Hello folks";
        });

        CompletableFuture<String> welcomeFuture = CompletableFuture.supplyAsync(() -> {
            return "Welcome folks";
        });

        CompletableFuture<String> com = helloFuture.thenCombine(welcomeFuture, (m1, m2) -> {
            return m1.length() + " " + m2.length();
        });

        System.out.println(com.get());


    }
}
