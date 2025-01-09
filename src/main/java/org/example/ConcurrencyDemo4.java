package org.example;

import java.util.concurrent.*;

class Sum implements Callable<Integer>{
    int val;

    Sum(int val){
        this.val = val;
    }

    public Integer call(){
        int sum = 0;
        for(int i=1; i <= val; i++){
            sum += i;
        }

        return sum;
    }
}

class Cube implements Callable<Integer>{
    int val;

    Cube(int val){
        this.val = val;
    }

    public Integer call(){
        return val*val*val;
    }
}

public class ConcurrencyDemo4 {
    public static void main(String[] args) throws Exception {
        Runtime rt = Runtime.getRuntime();
        int pr = rt.availableProcessors();
        System.out.println("Total no of processors = " + pr);

        ExecutorService es = Executors.newFixedThreadPool(pr);

        Future<Integer> f1 = es.submit(new Sum(10));
        Future<Integer> f2 = es.submit(new Cube(5));
        Future<Integer> f3 = es.submit(new Sum(6));

        System.out.println("f1 = " + f1.get());
        System.out.println("f2 = " + f2.get());
        System.out.println("f3 = " + f3.get());

        es.shutdown();



    }
}
