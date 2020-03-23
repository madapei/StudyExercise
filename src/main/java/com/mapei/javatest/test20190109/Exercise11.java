package com.mapei.javatest.test20190109;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/10
 */
public class Exercise11 {
    private class InnerClass implements Contents{
        @Override
        public int value() {
            return 999;
        }
    }

    public Contents getInnerClass(){
        return new InnerClass();
    }

    public InnerClass getInner(){
        return new InnerClass();
    }

    public static void main(String[] args) {
        Exercise11 e = new Exercise11();
        InnerClass ic = e.getInner();
    }
}
