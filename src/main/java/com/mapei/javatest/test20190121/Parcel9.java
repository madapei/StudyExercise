package com.mapei.javatest.test20190121;

import com.mapei.javatest.test20190109.Destination;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/23
 */
public class Parcel9 {
    public Destination destination(String dest){
        return new Destination() {
            @Override
            public String readLable() {
                return "";
            }
        };
    }
}
