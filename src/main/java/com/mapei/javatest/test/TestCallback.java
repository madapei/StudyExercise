package com.mapei.javatest.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/12/31
 */
public class TestCallback {
    public static void main(String[] args) {
        TestA test = new TestA();
        test.execute(array -> {
            List<String> result = Arrays.stream(array).filter(x -> x.length() < 10).collect(Collectors.toList());
            System.out.println(result);
        });
    }

}
