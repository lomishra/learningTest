package com.cisco.second.module.multitask;

import java.util.concurrent.BlockingQueue;

public class Cons implements Runnable{

    BlockingQueue<Integer> block;

    public Cons(BlockingQueue block){
        this.block = block;
    }
    @Override
    public void run() {
        for(int i=  1;i < 30; i++) {
            try {
               System.out.println("Consumer Thread: %s consume: %s "+ Thread.currentThread().getName() + " "+block.take());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
