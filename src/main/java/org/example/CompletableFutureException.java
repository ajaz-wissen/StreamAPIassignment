package org.example;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureException {
    public static void main(String[] args) throws Exception {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10/3)
                .exceptionally(ex -> 0);

        // 0 -> returned by the exceptionally() block
        System.out.println(future1.get());


    }
}
