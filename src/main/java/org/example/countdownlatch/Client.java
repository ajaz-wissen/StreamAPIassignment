package org.example.countdownlatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class Result{
    String name;
    long time;

    public Result(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}

class Biker implements Runnable {
    String name;
    int delay;
    CountDownLatch startSignal;
    CountDownLatch endSignal;

    Biker(String name, int delay, CountDownLatch startSignal, CountDownLatch endSignal){
        this.name = name;
        this.delay = delay;
        this.startSignal = startSignal;
        this.endSignal = endSignal;
        new Thread(this).start();
    }

    public void run(){
        long startTime = 0;
        long endTime = 0;
        try{
            startSignal.await();
            startTime = System.currentTimeMillis();
            System.out.println(name + " started at: " + startTime + " and duration: " + delay);
            Thread.sleep(delay);
            endTime = System.currentTimeMillis();
            System.out.println(name + " finished in time: " + (endTime - startTime));

        }catch (Exception e){
            System.out.println(e);
        }finally {
            endSignal.countDown();

        }

    }
}

public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int numBikers = 5;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch endSignal = new CountDownLatch(numBikers);

//        ExecutorService es = Executors.newFixedThreadPool(10);
        Random random = new Random();

//        for(int i=0; i < 5; i++){
//            Future<Result> f1 = es.submit(new Biker("Bike A", random.nextInt(2001), startSignal, endSignal));

//        }

//        Future<Result> f2 = es.submit(new Biker("Bike B", random.nextInt(2001), startSignal, endSignal));
//        Future<Result> f3 = es.submit(new Biker("Bike C", random.nextInt(2001), startSignal, endSignal));
//
//        List<Result> list = Arrays.asList(f1.get(), f2.get(), f3.get());
//
//        es.shutdown();

        for(int i=0; i < numBikers; i++){
            new Biker("Biker " + (char)(i + 'A'), random.nextInt(2001), startSignal, endSignal);
        }

        System.out.println("Starting the Race...");
        Thread.sleep(3000);

        startSignal.countDown();

        endSignal.await();

        System.out.println("Race ended...");


    }
}
