package com.mapei.javatest.test20190109;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/11
 */
public class E19 {
    class Inner1{
        class Inner2{
            void f(){
                System.out.println("This is in Inner2");
            }
        }

        Inner2 makeInner2(){
            return new Inner2();
        }
    }
    Inner1 makeInner1(){
        return new Inner1();
    }

    static class Nested1{
        static class Nested2{
            void f(){
                System.out.println("This is in Nested2");
            }
        }
        void f(){
            System.out.println("This is in Nested1");
        }
    }

    public static void main(String[] args) {
        new E19.Nested1().f();
        new E19.Nested1.Nested2().f();
        E19 x1 = new E19();
        E19.Inner1 x2 = x1.makeInner1();
        E19.Inner1.Inner2 x3 = x2.makeInner2();
        x3.f();
    }

}
