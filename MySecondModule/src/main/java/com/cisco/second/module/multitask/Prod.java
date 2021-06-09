package com.cisco.second.module.multitask;

import java.util.concurrent.BlockingQueue;

public class Prod implements Runnable{

    BlockingQueue<Integer> block;

    public Prod(BlockingQueue<Integer> block) {
        this.block = block;
    }

    @Override
    public void run() {
        for(int i=  1;i < 30; i++) {
            try {
                System.out.println("Producer produce: "+i);
                block.put(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
