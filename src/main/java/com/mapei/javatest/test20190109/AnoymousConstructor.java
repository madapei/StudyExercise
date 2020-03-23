package com.mapei.javatest.test20190109;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/10
 */
abstract class Base{
    public Base(int i){
        System.out.println("Base constructor.i = " + i);
    }
    public abstract  void f();
}
public class AnoymousConstructor {
    public static Base getBase(int i){
        return new Base(i){
            {
                System.out.println("Inside instance initializer " + i);
            }
            public void f(){
                System.out.println("In anonymous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base b = getBase(25);
        b.f();
    }
}
