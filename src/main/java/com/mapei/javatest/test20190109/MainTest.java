package com.mapei.javatest.test20190109;

import sun.applet.Main;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/9
 */
public class MainTest {
    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        mainTest.exercise1();
    }

    public void exercise1(){
        Exercise1 exercise1 = new Exercise1("mapei");
        Sequence sequence = new Sequence(3);
        sequence.add(exercise1);
        sequence.add("dapei");
        sequence.add(Integer.MIN_VALUE);
        Selector selector = sequence.selector();
        while(!selector.end()){
            System.out.println(selector.current());
            selector.next();
        }
    }

    public void test1(){
        DotThis dotThis = new DotThis();
        DotThis.Inner inner = dotThis.new Inner();
    }
}
