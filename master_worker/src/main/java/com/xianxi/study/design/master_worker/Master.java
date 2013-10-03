package com.xianxi.study.design.master_worker;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 负责接收和分配子任务给Worker,并对各Worker执行的结果进行汇总。
 *
 * @author zengxianxi
 * @since 13-10-3 下午3:29
 */
public class Master {
    /**
     * 任务队列
     */
    protected Queue<Object> workQueue = new ConcurrentLinkedDeque<Object>();
    /**
     * Worker
     */
    protected Map<String, Thread> threadMap = new HashMap<String, Thread>();
    /**
     * 子任务处理的结果集
     */
    protected Map<String, Object> resultMap = new ConcurrentHashMap<String, Object>();


    /**
     * 构造Master
     *
     * @param worker
     * @param workerCount 所需的worker数量
     */
    public Master(Worker worker, int workerCount) {
        worker.setResultMap(resultMap);
        worker.setWorkQueue(workQueue);
        for (int i = 0; i < workerCount; i++) {
            threadMap.put(Integer.toString(i), new Thread(worker));
        }
    }

    /**
     * 提交一个任务
     *
     * @param task
     */
    public void submit(Object task) {
        workQueue.add(task);
    }

    /**
     * 是否所有的子任务都执行完成
     *
     * @return
     */
    public boolean isComplete() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            if (entry.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 返回子任务结果集
     *
     * @return
     */
    public Map<String, Object> getResultMap() {
        return resultMap;
    }

    /**
     * 启动所有的worker开始工作
     */
    public void execute() {
        for (Map.Entry<String, Thread> entry : threadMap.entrySet()) {
            entry.getValue().start();
        }
    }
}
