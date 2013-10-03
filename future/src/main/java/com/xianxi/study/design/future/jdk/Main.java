package com.xianxi.study.design.future.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author zengxianxi
 * @since 13-10-3 下午2:36
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        RealData realData = new RealData("jdk future");
        //构造一个Future任务
        FutureTask<String> futureTask = new FutureTask<String>(realData);
        //
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(futureTask);
        System.out.println("请求完毕，任务已提交");
        //这里可以处理其它的业务逻辑，可能需要一些时间，用sleep模拟
        Thread.sleep(2000);
        System.out.println("futureTask data = " + futureTask.get());
        executorService.shutdown();
    }
}
