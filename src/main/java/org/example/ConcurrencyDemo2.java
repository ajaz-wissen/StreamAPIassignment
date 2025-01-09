package org.example;

import java.util.concurrent.Semaphore;

class Shared1{
    static int count = 1;
}

class IncThread1 implements Runnable{
    String name;
    Semaphore sem;

    public IncThread1(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
        new Thread(this).start();
    }

    @Override
    public void run() {

        try{
            System.out.println(name + " is waiting for permission");
            Thread.sleep(2000);
            sem.acquire();
            for(int i=1; i <= 20; i++){
                System.out.println(name + " :" + Shared1.count++);
                Thread.sleep(300);
            }
            sem.release();
            System.out.println(name + " released the permission");
        }catch (Exception e){
            System.out.println(e);
        }

    }
}

class DecThread1 implements Runnable{
    String name;
    Semaphore sem;

    public DecThread1(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
        new Thread(this).start();
    }

    @Override
    public void run() {

        try{
            System.out.println(name + " is waiting for permission");
            Thread.sleep(2000);
            sem.acquire();
            for(int i=1; i <= 20; i++){
                System.out.println(name + ": " + Shared1.count--);
                Thread.sleep(300);
            }
            sem.release();
            System.out.println(name + " released the permission");
        }catch (Exception e){
            System.out.println(e);
        }

    }
}

public class ConcurrencyDemo2 {
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(1);

        new IncThread1("Ajaz", sem);
        new DecThread1("Ahmed", sem);
        new IncThread1("Khan", sem);
        new IncThread1("Yusuf", sem);




    }
}
