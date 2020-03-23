package com.mapei.javatest.test_enum;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/7/31
 */
public enum ConstantSpecificMethod {
    DATE_TIME{
        String getInfo(){
            return DateFormat.getInstance().format(new Date());
        }
    },
    CLASSPATH{
        String getInfo(){
            return System.getenv("CLASSPATH");
        }
    },
    VERSION{
        String getInfo(){
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()){
            System.out.println(csm.getInfo());
        }
    }
}
