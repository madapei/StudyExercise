package com.mapei.javatest.test20190121;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/23
 */
interface WithNested{
    class Nested{
        int i;
        public Nested(int i){
            this.i = i;
        }
        void f(){
            System.out.println("Nested.f");
        }
    }
}

public class InterfaceWithNested {
    public static void main(String[] args) {
        WithNested.Nested wn = new WithNested.Nested(3);
        wn.f();
    }
}
