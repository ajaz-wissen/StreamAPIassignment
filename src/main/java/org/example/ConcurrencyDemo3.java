package org.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Shared2
{
    static AtomicInteger count = new AtomicInteger(1);
}

class MyThread implements Runnable
{
    String name;
    ReentrantLock lock;
    MyThread(String n, ReentrantLock l)
    {
        name = n;
        lock = l;
        new Thread(this).start();
    }
    public void run()
    {
        try
        {
            System.out.println(name+ " is waiting for the permission");
            Thread.sleep(2000);
            lock.lock();
            System.out.println(name+ "got the permission");
            lock.lock();
            System.out.println("Triple Security enabled for "+name);
            lock.lock();
            for(int i=1; i<=5; i++)
            {
                System.out.println(name+" : "+Shared2.count.getAndIncrement());
                Thread.sleep(1000);
            }
            lock.unlock();
            System.out.println(name+" released the permission");
            lock.unlock();
            System.out.println("Triple Security disabled for "+name);
            lock.unlock();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
public class ConcurrencyDemo3
{
    public static void main(String[] args)
    {
        ReentrantLock lock = new ReentrantLock();
        new MyThread("Vikas Kumar Singh", lock);
        new MyThread("Spana Badhkal", lock);
        new MyThread("Gaurav Baranwal", lock);
    }

}
