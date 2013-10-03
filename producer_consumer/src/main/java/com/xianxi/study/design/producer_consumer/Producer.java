package com.xianxi.study.design.producer_consumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者
 *
 * @author zengxianxi
 * @since 13-10-4 上午2:19
 */
public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;//内存缓冲区
    private static AtomicInteger count = new AtomicInteger();//总数，原子操作

    private final static int SLEEP_TIME = 1000;

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data = null;
        Random random = new Random();
        System.out.println("start producer id =" + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(random.nextInt(1000));
                data = new PCData(count.incrementAndGet());
                System.out.println(data + "is put into queue");
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("failed to put data:" + data);
                }
            }
            System.out.println("stop producer id=" + Thread.currentThread().getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 停止生产
     */
    public void stop() {
        isRunning = false;
    }
}
