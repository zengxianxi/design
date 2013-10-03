package com.xianxi.study.design.master_worker;

import java.util.Map;
import java.util.Queue;

/**
 * 执行子任务的Worker,worker主动从workQueue中取任务并执行，并将执行的结果放入resultMap中，
 * 直到所有的任务全部执行。
 *
 * @author zengxianxi
 * @since 13-10-3 下午3:48
 */
public abstract class Worker implements Runnable {

    protected Queue<Object> workQueue;
    protected Map<String, Object> resultMap;

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public void setWorkQueue(Queue<Object> workQueue) {

        this.workQueue = workQueue;
    }

    @Override
    public void run() {
        while (true) {
            //获取子任务
            Object input = workQueue.poll();
            if (input == null) break;
            //处理子任务
            Object o = handle(input);
            //将处理结果放入resultMap
            resultMap.put(Integer.toString(input.hashCode()), o);
        }
    }

    /**
     * 子任务处理的逻辑
     *
     * @param input
     * @return
     */
    protected abstract Object handle(Object input);
}
