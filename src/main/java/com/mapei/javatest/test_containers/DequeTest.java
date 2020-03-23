package com.mapei.javatest.test_containers;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/19
 */
public class DequeTest {
    static void fillTest(Deque<Integer> deque){
        for (int i = 20; i < 27; i++){
            deque.addFirst(i);
        }
        for (int i = 50; i < 55; i++){
            deque.addLast(i);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> di = new ArrayDeque<>();
        fillTest(di);
        System.out.println(di);
        while(di.size() != 0){
            System.out.print(di.removeFirst() + " ");
        }
        System.out.println();
        fillTest(di);
        while(di.size() != 0){
            System.out.print(di.removeLast() + " ");
        }
        System.out.println();
    }
}
