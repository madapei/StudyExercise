package com.mapei.javatest.test20181228;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/28
 */
public class UsepRrototype {
    private ProtoTypeTest protoTypeTest;

    @Autowired
    public UsepRrototype(ProtoTypeTest protoTypeTest) {
        this.protoTypeTest = protoTypeTest;
    }

    public void print(){
        protoTypeTest.printHash();
    }
}
