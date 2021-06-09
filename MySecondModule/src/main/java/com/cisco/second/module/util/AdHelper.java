package com.cisco.second.module.util;

import java.util.concurrent.SynchronousQueue;

public class AdHelper {

    public int sum;

    boolean isProduce = true;

    public synchronized void produce() {
        while (true) {
            if (!isProduce) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Producer is produced: " + ++sum);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isProduce = false;
            notify();
        }
    }

    public synchronized void consume() {
        while (true){
            if (isProduce) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        System.out.println("Consume the data:" + sum);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isProduce = true;
        notify();
    }

}

    /**
     * This method will print the result of adding given numbers
     * @param a
     * @param b
     */
    public static void addOperation(int a, int b){

        System.out.println("Result of your operation is :"+ (a+b));
    }
}
