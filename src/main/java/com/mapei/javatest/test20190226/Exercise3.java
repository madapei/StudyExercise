package com.mapei.javatest.test20190226;

import java.util.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/2/27
 */
public class Exercise3 {
    private static Random random = new Random(47);
    private List<Integer> list = new ArrayList<Integer>();
    public static void printQ(Queue queue){
        for (Object data = queue.poll(); data != null; data = queue.poll()){
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue<Double> priorityQueue = new PriorityQueue<Double>();
        for (int i = 0; i < 10; i++){
            priorityQueue.offer(random.nextDouble());
        }
        printQ(priorityQueue);
    }
}
