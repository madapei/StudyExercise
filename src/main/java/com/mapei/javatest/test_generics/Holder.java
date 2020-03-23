package com.mapei.javatest.test_generics;

import com.mapei.javatest.test_typeInformation.ShowMethods;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/3/14
 */
public class Holder<T> {
    private T a;
    public Holder(T a){
        this.a = a;
    }
    public void set(T a){
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        Holder<ShowMethods> h = new Holder<ShowMethods>(new ShowMethods());
        ShowMethods s = h.get();
        s.toString();
    }
}
