package com.xianxi.study.design.producer_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author zengxianxi
 * @since 13-10-4 上午3:12
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>();
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);

        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(producer1);
        executorService.execute(producer2);
        executorService.execute(producer3);

        executorService.execute(consumer1);
        executorService.execute(consumer2);
        executorService.execute(consumer3);

        Thread.sleep(10 * 1000);

        producer1.stop();
        producer2.stop();
        producer3.stop();
        Thread.sleep(3000);
        executorService.shutdown();

    }
}
