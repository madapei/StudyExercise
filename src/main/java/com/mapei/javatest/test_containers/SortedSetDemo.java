package com.mapei.javatest.test_containers;

import edu.emory.mathcs.backport.java.util.Collections;

import java.util.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/19
 */
public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> sortedSet = new TreeSet<>();
        Collections.addAll(sortedSet, "one two three four five six seven eight nine ten".split(" "));
        System.out.println(sortedSet);
        String low = sortedSet.first();
        System.out.println("low:" + low);
        String high = sortedSet.last();
        System.out.println("high:" + high);
        Iterator<String> iterator = sortedSet.iterator();
        for (int i = 0; i <= 6; i++){
            if (i == 3){
                low = iterator.next();
            }
            if (i == 6){
                high = iterator.next();
            }
            else {
                iterator.next();
            }
        }
        Comparator c = sortedSet.comparator();
        System.out.println("low:" + low);
        System.out.println("high:" + high);
        System.out.println(sortedSet.subSet(low, high));
        System.out.println(sortedSet.headSet(high));
        System.out.println(sortedSet.tailSet(low));
    }
}
