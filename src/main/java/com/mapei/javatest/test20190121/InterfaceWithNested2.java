package com.mapei.javatest.test20190121;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/23
 */
interface I{
    void f();
    void g();
    class Nested{
        static void call(I impl){
            System.out.println("Calling I.f()");
            impl.f();
            System.out.println("Calling I.g()");
            impl.g();
        }
    }
}

public class InterfaceWithNested2 {
    public static void main(String[] args) {
        I impl = new I() {
            @Override
            public void f() {

            }

            @Override
            public void g() {

            }
        };
        I.Nested.call(impl);
    }
}
