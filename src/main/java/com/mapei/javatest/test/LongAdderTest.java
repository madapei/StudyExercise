package com.mapei.javatest.test;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2020/1/3
 */
public class LongAdderTest {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.add(123);
        longAdder.add(456);
        System.out.println("-----adder result : " + longAdder.sum());

        LongAccumulator longAccumulator = new LongAccumulator((x, y) -> (x+y)/2, 0);
        longAccumulator.accumulate(123);
        longAccumulator.accumulate(456);
        System.out.println("-----accumulate result : " + longAccumulator.longValue());
    }
}
