package com.mapei.javatest.test_generics;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/3/15
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("jase");
        list.add("gase");
        list.add("gava");
        list.add("jadedfs");

        int c = 0;
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String item = iterator.next();
            if (item.startsWith("ja")){
                c++;
            }
        }
        System.out.println("c=" + c);

        long l = list.stream().filter(item -> item.startsWith("ja")).count();
        list.stream().filter(item -> {
            System.out.println("hello:" + item);
            return item.startsWith("ja"); });
        System.out.println("l=" + l);

    }
}
