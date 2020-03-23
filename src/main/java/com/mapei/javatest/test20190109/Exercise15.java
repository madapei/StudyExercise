package com.mapei.javatest.test20190109;

import junit.framework.TestCase;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/10
 */
class TestClass{
    String name;
    TestClass(String nameParam){
        name = nameParam;
    }

    void print(){
        System.out.println(name);
    }
}
public class Exercise15 {
    public TestClass getTest(String name){
        return new TestClass(name){
            void print(){
                System.out.println(name);
            }
        };
    }

    public static void main(String[] args) {
        Exercise15 e = new Exercise15();
        TestClass t =  e.getTest("Hello");
        t.print();
    }
}
