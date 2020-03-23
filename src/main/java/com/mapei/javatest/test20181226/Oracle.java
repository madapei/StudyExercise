package com.mapei.javatest.test20181226;

import org.springframework.stereotype.Component;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/27
 */
@Component
public class Oracle implements DbType{
//    private String typeName;

//    public Oracle() {
//        this.typeName = typeName;
//    }

    public String getDbType(){
        return "Oracle";
    }

}
