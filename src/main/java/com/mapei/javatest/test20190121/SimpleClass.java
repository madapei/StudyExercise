package com.mapei.javatest.test20190121;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/22
 */
public class SimpleClass {
    protected class InnerTestT implements SimpleInterface{
        public void f(){
            System.out.println("f()");
        }
    }
}
