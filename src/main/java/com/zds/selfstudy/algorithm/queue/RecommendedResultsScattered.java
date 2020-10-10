package com.zds.selfstudy.algorithm.queue;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @program: self-study
 * @description: 推荐结果打散
 * @author: zhaods
 * @create: 2020-10-02 20:57
 **/
public class RecommendedResultsScattered {
    public static void main(String[] args) {
        List<String> recommends = Arrays.asList("v_0"
                , "v_1", "v_2", "p_3"
                , "p_4", "p_5", "v_6"
                , "p_7", "v_8", "v_9");

        String mark = "v_";
        int maxInterval = 1;
        List<String> results = getRecommendedResults(recommends, mark, maxInterval);
        System.out.println(JSONObject.toJSONString(results, true));
    }

    private static List<String> getRecommendedResults(List<String> recommends, String mark, int maxInterval) {
        List<String> results = new ArrayList<>();
        if (null == recommends || recommends.isEmpty()) {
            return results;
        }
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        boolean belongToQueue2First = false;
        int index = 0;
        int recommendsSize = recommends.size();
        while (!belongToQueue2First && index < recommendsSize) {
            String content = recommends.get(index);
            if (isBelongToQueue1(mark, content)) {
                results.add(index, content);
                index++;
            } else {
                belongToQueue2First = true;
            }

        }
        while (index < recommendsSize) {
            String content = recommends.get(index);
            if (isBelongToQueue1(mark, content)) {
                queue1.add(content);
            } else {
                queue2.add(content);
            }
            index++;
        }
        int currentSize = results.size();
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (currentSize >= maxInterval) {
                results.add(queue2.poll());
                currentSize = 0;
            } else {
                results.add(queue1.poll());
                currentSize++;
            }
        }
        while (!queue1.isEmpty()) {
            results.add(queue1.poll());
        }
        while (currentSize >= maxInterval && !queue2.isEmpty()) {
            results.add(queue2.poll());
        }

        return results;
    }

    public static boolean isBelongToQueue1(String mark, String str) {
        return str.contains(mark);
    }

}
