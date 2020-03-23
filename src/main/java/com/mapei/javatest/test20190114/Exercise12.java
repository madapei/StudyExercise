package com.mapei.javatest.test20190114;

import java.util.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/14
 */
public class Exercise12 {
    /*public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
        List<Integer> list2 = new ArrayList<Integer>(list1.size());
        System.out.println(list1);
        ListIterator<Integer> iterator = list1.listIterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        while (iterator.hasPrevious()){
            list2.add(iterator.previous());
        }
        System.out.println(list2);
    }*/
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
        List<Integer> list2 = new ArrayList<Integer>(list1);
        ListIterator<Integer> iteratorZ = list2.listIterator();
        ListIterator<Integer> iteratorF = list2.listIterator(list2.size());
        System.out.println(list1);
        int mid = list2.size() >> 1;
        for (int i = 0; i < mid; i ++){
            int temp = iteratorZ.next();
            iteratorZ.set(iteratorF.previous());
            iteratorF.set(temp);
        }
        System.out.println(list2);
    }
}
