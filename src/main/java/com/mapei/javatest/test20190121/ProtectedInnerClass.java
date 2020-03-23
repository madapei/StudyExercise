package com.mapei.javatest.test20190121;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/22
 */
public class ProtectedInnerClass extends SimpleClass{

    public SimpleInterface get(){
        return new InnerTestT();
    }

    public static void main(String[] args) {
        new ProtectedInnerClass().get().f();
    }
}
