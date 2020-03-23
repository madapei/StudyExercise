package com.mapei.javatest.test20190109;

import com.mapei.javatest.test20190104.TestInterface;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/10
 */
public class OutAndInnerTest {
    protected class TestInner implements TestInterface{
        @Override
        public void printName() {
            System.out.println("This is OutAndInnerTest.Inner class!");
        }

        public TestInner(){}
    }
}
