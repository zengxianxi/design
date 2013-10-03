package com.xianxi.study.design.producer_consumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 *
 * @author zengxianxi
 * @since 13-10-4 上午2:49
 */
public class Consumer implements Runnable {
    private BlockingQueue<PCData> queue;

    private static final int SLEEP_TIME = 1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start consumer id=" + Thread.currentThread().getId());
        Random random = new Random();
        try {
            while (true) {
                PCData data = queue.take();
                if (data != null) {
                    int re = data.getData() * data.getData();//计算平方
                    System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(), data.getData(), re));
                    Thread.sleep(random.nextInt(SLEEP_TIME));
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
