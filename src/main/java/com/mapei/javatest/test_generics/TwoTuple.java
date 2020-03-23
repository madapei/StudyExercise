package com.mapei.javatest.test_generics;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/3/14
 */
public class TwoTuple<A,B> {
    private A first;
    private B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public static void main(String[] args) {
        TwoTuple twoTest = new TwoTuple(new First(), new Second());
        System.out.println(twoTest.toString());
    }
}
