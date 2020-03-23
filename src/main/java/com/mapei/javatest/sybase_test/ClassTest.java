package com.mapei.javatest.sybase_test;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/3
 */
public class ClassTest {
    private String name;
    private String age = "28";

    public ClassTest(String name) {
        this.name = name;
    }

    public void publicMethod(){
        System.out.println("This is publicMethod");
    }

    private void privateMethod(){
        System.out.println("This is privateMethod");
    }

    protected void protectedMethod(){
        System.out.println("This is protectedMethod" );
    }
    private class InnerTest{}
}
