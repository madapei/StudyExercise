package com.mapei.javatest.test20190114;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/16
 */
class parent{
    public void print(){
        System.out.println("This is parent!");
    }
    public static void find(){
        System.out.println("This is parent find()!");
    }
}
public class JavaBaseTest extends parent{


    public static void main(String[] args) {
        JavaBaseTest test = new JavaBaseTest();
        test.print();
        find();
//        parent.find();

    }

    @Override
    public void print(){
        System.out.println("This is child!");
    }

//    public static void find(){
//        System.out.println("This is child find()!");
//    }
}
