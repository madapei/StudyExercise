package com.mapei.javatest.test20190226;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/2/27
 */
public class MyCollection implements Iterable<String>{
    public String[] strArray;
    int i = 0;

    public MyCollection(String[] strArray) {
        this.strArray = strArray;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return i < strArray.length;
            }

            @Override
            public Object next() {
                return strArray[i++];
            }
        };
    }
}
