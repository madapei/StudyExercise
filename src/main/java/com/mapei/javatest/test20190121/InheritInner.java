package com.mapei.javatest.test20190121;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/23
 */
class WithInner{
    class Inner{
        void f(){
            System.out.println("f()");
        }
    }
}

public class InheritInner extends WithInner.Inner{
    InheritInner (WithInner inner){
        inner.super();
    }

    public static void main(String[] args) {
        InheritInner in = new InheritInner(new WithInner());
        in.f();
    }
}
