package com.mapei.javatest.test_containers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/19
 */
public class QueueBehavior {
    static class Gen{
        String[] s = "one two three four five six seven eight nine ten".split(" ");
        int i;
        public String next(){
            return s[i++];
        }
    }

    static void test(Queue queue, Gen gen){
        for (int i = 0; i < 10; i++){
            queue.offer(gen.next());
        }
        while (queue.peek() != null){
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test(new LinkedList<String>(), new Gen());
        test(new PriorityQueue(), new Gen());
        test(new ArrayBlockingQueue(10), new Gen());
        test(new ConcurrentLinkedQueue(), new Gen());
        test(new LinkedBlockingQueue(), new Gen());
        test(new PriorityBlockingQueue(), new Gen());
    }
}
