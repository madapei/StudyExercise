package com.mapei.javatest.test_containers;

import java.util.LinkedHashMap;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/6/18
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(0, "a0");
        linkedMap.put(2, "c0");
        linkedMap.put(1, "b0");
        linkedMap.put(3, "d0");
        System.out.println(linkedMap);

        linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.put(0, "A0");
        linkedMap.put(1, "B0");
        linkedMap.put(2, "C0");
        linkedMap.put(3, "D0");
        System.out.println(linkedMap);

        for (int i = 0; i < 3; i++){
            linkedMap.get(i);
        }
        System.out.println(linkedMap);
        linkedMap.get(0);
        System.out.println(linkedMap);
    }
}
