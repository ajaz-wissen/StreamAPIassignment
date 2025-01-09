package org.example;

// 1. get()
// 2. set(newValue)
// 3. getAndSet(newValue)
// 4. compareAndSet(expectedValue, newValue)

/*
Numeric classes only
1. incrementAndGet() => ++x
2. getAndIncrement() => x++
3. decrementAndGet() => --x
4. getAndDecrement() => x--
 */

// No duplicated numbers; guaranteed to get to 10
// However, order is still not guaranteed (Insertion order is not preserved)

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    private static AtomicInteger atomicCount = new AtomicInteger(0);
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i=1; i <= 10; i++){
            es.submit(() -> System.out.println(atomicCount.incrementAndGet()));
        }

        es.shutdown();
    }
}
