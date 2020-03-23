package com.mapei.javatest.test_containers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/17
 */
public class QueueBehaviorNew {
    private static int count = 10;
    static class Gen{
        String[] s = ("one two three four five six seven eight nine ten").split(" ");
        int i;
        public String next(){
            return s[i++];
        }
    }
    static  void test(Queue<String> queue, Gen gen){
        for (int i = 0; i < count; i++){
            queue.offer(gen.next());
        }
        while (queue.peek() != null){
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test(new LinkedList<>(), new Gen());
        test(new PriorityQueue<>(), new Gen());
    }
}
