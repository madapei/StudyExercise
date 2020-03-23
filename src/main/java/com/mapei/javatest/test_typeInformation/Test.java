package com.mapei.javatest.test_typeInformation;

import javax.xml.bind.SchemaOutputResolver;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/3/12
 */
class HelloTest{
    static  String name = "mapei";
    static{
        System.out.println("Hello Test init!");
    }
}
public class Test {
    public static void main(String[] args) {
//        Class ht = HelloTest.class;
//        System.out.println(ht.getCanonicalName());
//        try {
//            Class c = Class.forName("com.mapei.javatest.test_typeInformation.HelloTest");
//            System.out.println(c.getCanonicalName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        System.out.println(HelloTest.name);
    }

}
