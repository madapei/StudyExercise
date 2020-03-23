package com.mapei.javatest.test20190218;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/2/18
 */
public class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();
//        Outer.Inner inner = outer.new Inner();
    }
    public void test(){
        Outer.Inner i = new Outer.Inner();
    }
}
