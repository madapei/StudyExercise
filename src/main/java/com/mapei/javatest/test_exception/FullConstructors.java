package com.mapei.javatest.test_exception;

import com.mapei.javatest.test20190226.MyCollection;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/2/28
 */
class MyException extends Exception{
    public MyException(){}
    public MyException(String msg){
        super(msg);
    }
}

public class FullConstructors {
    public static void f() throws MyException{
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException{
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}
