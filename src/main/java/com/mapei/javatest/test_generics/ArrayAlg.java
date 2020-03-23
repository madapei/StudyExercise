package com.mapei.javatest.test_generics;

import java.util.Collection;
import java.util.Collections;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/4/8
 */
public class ArrayAlg<T> {
    private T obj;
    private T st;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public <T> void addAll(Collection<T> coll, T ... ts){
        for (T t : ts){
            coll.add(t);
        }
    }

}
