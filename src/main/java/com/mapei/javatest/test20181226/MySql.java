package com.mapei.javatest.test20181226;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/27
 */
@Component
public class MySql implements DbType{
//    private String typeName;
//
//    public MySql(String typeName) {
//        this.typeName = typeName;
//    }
    public MySql(){
        System.out.println("In MySql:" + this.hashCode());
    }


    public String getDbType() {
        return "MySql";
    }
}
