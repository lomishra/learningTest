package com.cisco.second.module.multitask;

import com.cisco.second.module.util.AdHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;

public class Multitask {

    CountDownLatch countDownLatch = new CountDownLatch(2);
    AdHelper adHelper = new AdHelper();
    public static void main(String[] args) {
        /*executorLearning();
        System.out.println("Stopping the Flow");*/
       // new Multitask().prodConsum();
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(30);
        Prod p1 = new Prod(blockingQueue);
        Cons p2 = new Cons(blockingQueue);
       // new Thread(p1).start();
       // new Thread(p2).start();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(p1);
        executorService.submit(p2);
        executorService.submit(new Cons(blockingQueue));
        executorService.shutdown();
    }

    public  void prodConsum(){

           var list = Arrays.asList(
                new Producer(countDownLatch,"Producer",adHelper),
                new Consumer(countDownLatch,"Consumer",adHelper)
        );

        ExecutorService ex =Executors.newScheduledThreadPool(2);
        for(Runnable rn : list){
            ex.submit(rn);
        }
        try {
           // countDownLatch.await();
            countDownLatch.await();
            System.out.println("After Countdown catch block");
           // ex.submit(() -> System.out.println("Third Thread is executing: " + Thread.currentThread().getName()));
            ex.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }






    public static void executorLearning(){

        ExecutorService executorService = Executors.newScheduledThreadPool(2);
        /*Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 5+7;
            }
        });*/
        Future<Integer> future = executorService.submit(() -> 5+7);
        executorService.submit(() -> {
            var j =0;
            while ( j<20) {
                System.out.println("running the while loop");
                j++;
            }
        });
        executorService.submit(() -> {
            var j =0;
            while ( j<10) {
                System.out.println("Inside the third thread");
                j++;
            }
        });


        try {
            int s = future.get();
            var i =0 ;

            if(!executorService.isShutdown()) {
                executorService.shutdown();
                System.out.println("Thread is getting shutdown");
                if(!executorService.isShutdown()) {
                    executorService.shutdownNow();
                    System.out.println("Thread is  shutdown:->>"+executorService.isShutdown());
                }
            }

            if(s==12){
                System.out.println("we are good for that");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
