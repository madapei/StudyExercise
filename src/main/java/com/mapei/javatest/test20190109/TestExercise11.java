package com.mapei.javatest.test20190109;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/10
 */
public class TestExercise11 {
    public static void main(String[] args) {
        B2 b = new B2();
        WithNested.Nested wn = new WithNested.Nested(1);
        E19 e = new E19();
        E19.Inner1 ei = e.new Inner1();
    }
}
