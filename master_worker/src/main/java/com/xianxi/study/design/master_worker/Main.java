package com.xianxi.study.design.master_worker;

import java.util.Map;
import java.util.Set;

/**
 * @author zengxianxi
 * @since 13-10-3 下午4:23
 */
public class Main {
    public static void main(String[] args) {
        Worker worker = new PlusWoker();
        Master master = new Master(worker, 5);

        //提交一100个子任务，每个子任务分别计算立方
        for (int i = 0; i < 100; i++) {
            master.submit(i);
        }
        master.execute();

        int result = 0;//最终计算的结果
        Map<String, Object> resultMap = master.getResultMap();
        while (resultMap.size() > 0 || !master.isComplete()) {
            Set<String> keys = resultMap.keySet();
            for (String key : keys) {
            System.out.println("key:"+key);
                if (key != null) {
                    Integer i = (Integer) resultMap.get(key);
                    if (i != null) {
                        result += i;
                    }
                    resultMap.remove(key);
                }

            }
        }
        System.out.println("result = " + result);
    }
}
