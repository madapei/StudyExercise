package com.mapei.javatest.test20181228.profile;

import org.springframework.stereotype.Component;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/28
 */
@Component
public class DevProfile implements ProfileReturn{
    public void printProfile() {
        System.out.println("This is devProfile");
    }
}
