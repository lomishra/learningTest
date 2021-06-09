package com.cisco.second.module.multitask;

import com.cisco.second.module.util.AdHelper;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class Consumer implements Runnable{
    CountDownLatch countDownLatch;
    AdHelper adHelper;

    public Consumer(CountDownLatch countDownLatch,String name,AdHelper adHelper) {
        this.countDownLatch = countDownLatch;
        Thread.currentThread().setName(name);
        this.adHelper = adHelper;
    }

    @Override
    public void run() {
        System.out.println("Inside the consumer Thread: "+Thread.currentThread().getName());

        try {
            adHelper.consume();
            sleep(500);
            } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }

}
