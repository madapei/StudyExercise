package com.mapei.javatest.test_thread.blocking_queue;

import java.util.HashSet;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/6/3
 */
public class LinkedBlockingQueueTest {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();//初始化时未指定容量，则默认容量为Integer.MAX_VALUE
        blockingQueue.add("what");
        blockingQueue.offer("is");
        try {
            blockingQueue.put("LinkedBlockingQueue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("init blocking queue: " + blockingQueue);
        blockingQueue.clear(); //清空队列中的所有元素
        System.out.println("after clear(): " + blockingQueue);
        int remainingCapacity =  blockingQueue.remainingCapacity();
        System.out.println("queue remaining capacity: " + remainingCapacity);

        Set<String> initSet = new HashSet<>();
        initSet.add("hello");
        initSet.add("world");
        initSet.add("!");
        blockingQueue = new LinkedBlockingQueue<>(initSet); //通过指定的Collection来初始化队列
        System.out.println("blocking queue from set: " + blockingQueue);
        boolean containsHello = blockingQueue.contains("hello"); //判断队列是否包含指定元素
        System.out.println("queue contains 'hello'? " + containsHello);
        remainingCapacity =  blockingQueue.remainingCapacity(); //获取队列的剩余容量
        System.out.println("queue remaining capacity: " + remainingCapacity + ", Integer.MAX_VALUE=" + Integer.MAX_VALUE);

        int size = blockingQueue.size(); //获取队列当前元素的个数
        System.out.println("current size: " + size);
    }
}
