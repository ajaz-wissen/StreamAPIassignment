package org.example;

/*
    1. put(E e)
    2. take()
    3. offer()
    4. poll()
*/

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) {

        BlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        // regular Queue methods
        try{
        queue.put("Red");
        queue.put("Green");
//        queue.offer("Blue");

//        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue);

        // Some special BlockingQueue methods

            // block happens when queue is full
            queue.offer("WHITE", 100, TimeUnit.MILLISECONDS);

//            queue.poll(80, TimeUnit.MILLISECONDS);

        }catch (InterruptedException e){
            System.out.println(e);
//            e.printStackTrace();
        }

        System.out.println(queue);

    }
}
