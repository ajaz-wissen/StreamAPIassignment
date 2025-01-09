package org.example;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureSupplyAsync {
    public static void main(String[] args) throws Exception {

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
           // Some Async operation
           return "Hello guys, welcome to Completable Future";
        });

        System.out.println(f1.get());


    }
}
