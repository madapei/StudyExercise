package com.mapei.javatest.test20190102;

import com.mapei.javatest.test20190104.TestInterface;
import com.mapei.javatest.test20190109.OutAndInnerTest;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/10
 */
public class ExtendsInnerTest extends OutAndInnerTest{
    public TestInterface getInterfaceImpl(){
        return new TestInner();
    }

    public static void main(String[] args) {
        ExtendsInnerTest test = new ExtendsInnerTest();
        test.getInterfaceImpl().printName();
    }
}
