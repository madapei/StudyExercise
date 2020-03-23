package com.mapei.javatest.test;

import edu.emory.mathcs.backport.java.util.Arrays;
import edu.emory.mathcs.backport.java.util.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/5/31
 */
public class UnmodifiableTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, new String[]{"a", "b", "c", "d"});
        LinkedList<String> linkedList = new LinkedList<>();
        Collections.addAll(linkedList, new String[]{"A", "B", "C", "D"});

        Iterator<String> arrayIterator = arrayList.iterator();
        Iterator<String> linkedIterator = linkedList.iterator();
        while (arrayIterator.hasNext()){
            System.out.print(arrayIterator.next() + " ");
        }
        System.out.println();
        while (linkedIterator.hasNext()){
            System.out.print(linkedIterator.next() + " ");
        }
    }
}
