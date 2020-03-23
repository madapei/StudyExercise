package com.mapei.javatest;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/22
 */
public class Outer {
    class Inner{
        public void print(){
            System.out.println("This is Inner class");
        }
    }

    public Inner getInner(){
        return new Inner();
    }
//
//    public static void main(String[] args) {
//        Outer outer = new Outer();
//        outer.test();
//    }
//    public void test(){
//        Inner inner = getInner();
//        inner.print();
//    }

    public static void main(String[] args) {
        String CURRENT_USER_ID = "25";
        Integer i = new Integer(25);
        if (CURRENT_USER_ID.equals(i)){
            System.out.println("hello");
        }
        else{
            System.out.println("error");
        }
    }

}
