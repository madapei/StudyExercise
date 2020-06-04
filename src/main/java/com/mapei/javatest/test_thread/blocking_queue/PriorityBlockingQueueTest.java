package com.mapei.javatest.test_thread.blocking_queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/6/3
 */
public class PriorityBlockingQueueTest {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        PriorityBlockingQueue<String> blockingQueue = new PriorityBlockingQueue<>();
        System.out.println("normal queue init capacity: " + blockingQueue.remainingCapacity()); //优先级阻塞队列中该方法永远返回Integer.MAX_VALUE，因为它本身是无界的。
        blockingQueue.add("hello");
        blockingQueue.offer("world");
        blockingQueue.put("a"); //因为PriorityBlockingQueue是无界的，所以take方法永远不会阻塞，所以这里没有抛出InterruptedException
        System.out.println("init normal queue: " + blockingQueue);
        blockingQueue.put("piapia");
        System.out.println("normal queue after put 'piapia': " + blockingQueue);

        //创建初始容量为0，按元素长度排序的阻塞队列
        PriorityBlockingQueue<String> comparatorBlockingQueue = new PriorityBlockingQueue<String>(10, (left, right) -> {
            if (left.length() > right.length()){
                return 1;
            }
            else if (left.length() < right.length()){
                return -1;
            }
            else {
                return 0;
            }
        });
        comparatorBlockingQueue.add("hello");
        comparatorBlockingQueue.offer("world");
        comparatorBlockingQueue.put("a");
        System.out.println("init comparator queue: " + comparatorBlockingQueue);
        comparatorBlockingQueue.put("piapia");
        System.out.println("comparator queue after put 'piapia': " + comparatorBlockingQueue);

        PriorityBlockingQueue<Integer> initCapacityQueue = new PriorityBlockingQueue<>(2);
        initCapacityQueue.put(2);
        initCapacityQueue.put(4);
        initCapacityQueue.put(5);
        System.out.println("init initCapacity queue: " + initCapacityQueue);

        PriorityBlockingQueue<ThisPerson> noComparatorBlockingQueue = new PriorityBlockingQueue<>();
        ThisPerson person1 = new ThisPerson("mapei");
        noComparatorBlockingQueue.put(person1);//如果试图往PriorityBlockingQueue中插入无法排序的对象，那么运行时会报异常
        System.out.println("init no comaparator queue: " + noComparatorBlockingQueue);
    }
}

class ThisPerson{
    private String name;

    public ThisPerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ThisPerson{" +
                "name='" + name + '\'' +
                '}';
    }
}
