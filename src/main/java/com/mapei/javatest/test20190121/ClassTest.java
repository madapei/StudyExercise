package com.mapei.javatest.test20190121;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/21
 */
public class ClassTest {
    private int outerCount = 2;

    public void printOut(){
        System.out.println(outerCount);
    }

    static class Inner{
        private int innerCount = 5;
        public void printInner(){
            System.out.println(innerCount);
        }
    }

    public void test(){
        Inner i = new Inner();
    }
}
