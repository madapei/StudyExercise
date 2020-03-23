package com.mapei.javatest.test_containers;

import java.util.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/16
 */
public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Iterator iterator = list.iterator();
        iterator.forEachRemaining(item ->{
            String str = item.toString().toUpperCase();
            System.out.println(str);
            if (item.equals("c"))
                System.out.println(123);
        });

        System.out.println(list.toString());
    }
}
