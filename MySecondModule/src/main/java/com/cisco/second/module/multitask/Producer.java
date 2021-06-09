package com.cisco.second.module.multitask;

import com.cisco.second.module.util.AdHelper;

import java.util.concurrent.CountDownLatch;

import static java.lang.Thread.sleep;

public class Producer implements Runnable{

    CountDownLatch countDownLatch;

    AdHelper adHelper;

    public Producer(CountDownLatch countDownLatch,String name, AdHelper adHelper) {
        Thread.currentThread().setName(name);
        this.countDownLatch = countDownLatch;
        this.adHelper = adHelper;

    }

    @Override
    public void run() {
        System.out.println("Producer Thread is running: "+ Thread.currentThread().getName());

        try {
            adHelper.produce();
            sleep(500);
            System.out.println("Producer Thread  After Sleep is running: "+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();

    }
}
