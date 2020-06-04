package com.mapei.javatest.test_thread.blocking_queue;

import edu.emory.mathcs.backport.java.util.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/6/3
 */
public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(3);
        /*for (int i = 0; i < 5; i++){
//            blockingQueue.add(i); //如果队列已满则抛异常:java.lang.IllegalStateException: Queue full
//            boolean result = blockingQueue.offer(i); // 如果队列已满，则返回false
            try {
                blockingQueue.put(i);// 如果队列已满则阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(blockingQueue);
        }*/
        blockingQueue.add(2); //向队列中添加一个元素，如果队列已满，则抛出异常
        blockingQueue.offer(3); //向队列中添加一个元素，如果队列已满，则返回false
        try {
            blockingQueue.put(1);//向队列中添加一个元素，如果队列已满，则阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(blockingQueue);

        List sortedList = Arrays.asList(blockingQueue.toArray());//将BlockingQueue转换为数组,并通过Arrays工具类转换为List
        Collections.sort(sortedList); //调用Collections工具类对list进行排序
        System.out.println("after to sorted list: " + sortedList);

        Iterator<Integer> iterator = blockingQueue.iterator(); //因为AbstractQueue实现了Collection接口，而Collection接口继承了Iterable接口，所以这里可以用迭代方法
        while (iterator.hasNext()){
            System.out.print(iterator.next() + ",");
        }
        System.out.println();

        blockingQueue.remove(new Integer(2)); //删除值为2的元素(因为它的父类AbstractQueue实现了Collection接口，所以也可以调用Collection方法)
        System.out.println(blockingQueue);

        List<Integer> list = new ArrayList<>();
        blockingQueue.drainTo(list, 4); //将BlockingQueue中的值移到指定的Collection中，第二个参数表示最多可移除的元素个数
        System.out.println("blocking queue: " + blockingQueue);
        System.out.println("list: " + list);

        List<Integer> initList = Arrays.asList(new Integer[]{10, 20, 30, 40});
        ArrayBlockingQueue<Integer> blockingQueue1 = new ArrayBlockingQueue<Integer>(10, false, initList);
        System.out.println("with initial element blockqueue: " + blockingQueue1);
        boolean containsResult = blockingQueue1.contains(20);
        System.out.println("queue contains 20? " + containsResult);

        int remainingCapacity =  blockingQueue1.remainingCapacity();
        System.out.println("queue remaining capacity: " + remainingCapacity);
    }
}
