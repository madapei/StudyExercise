package com.mapei.javatest.test_containers;

import java.util.LinkedHashMap;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/22
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(0, "ZERO");
        linkedHashMap.put(1, "ONE");
        linkedHashMap.put(2, "TWO");
        linkedHashMap.put(3, "THREE");
        linkedHashMap.put(4, "FOUR");
        linkedHashMap.put(5, "FIVE");
        linkedHashMap.put(6, "SIX");
        linkedHashMap.put(7, "SEVEN");
        linkedHashMap.put(8, "EIGHT");
        linkedHashMap.put(9, "NINE");
        System.out.println(linkedHashMap);
        linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put(0, "ZERO");
        linkedHashMap.put(1, "ONE");
        linkedHashMap.put(2, "TWO");
        linkedHashMap.put(3, "THREE");
        linkedHashMap.put(4, "FOUR");
        linkedHashMap.put(5, "FIVE");
        linkedHashMap.put(6, "SIX");
        linkedHashMap.put(7, "SEVEN");
        linkedHashMap.put(8, "EIGHT");
        linkedHashMap.put(9, "NINE");
        System.out.println(linkedHashMap);
        for (int i = 0; i < 6; i++){
            linkedHashMap.get(i);
        }
        System.out.println(linkedHashMap);
        linkedHashMap.get(0);
        System.out.println(linkedHashMap);

    }
}
