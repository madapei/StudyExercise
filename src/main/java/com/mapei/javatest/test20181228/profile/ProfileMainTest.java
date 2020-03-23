package com.mapei.javatest.test20181228.profile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/28
 */
public class ProfileMainTest {
    private ApplicationContext context;

    public void init(){
        context = new AnnotationConfigApplicationContext(ProfileConfig.class);
    }

    public void profileTest(){
        ProfileReturn profileReturn = context.getBean(ProfileReturn.class);
        profileReturn.printProfile();
    }

    public void getActiveProfile(){
        ProfileConfig profileConfig = context.getBean(ProfileConfig.class);
        profileConfig.printActiveProfile();
        System.out.println(profileConfig.testAcceptProfile("dev"));
    }

    public static void main(String[] args) {
        ProfileMainTest profileMainTest = new ProfileMainTest();
        profileMainTest.init();
//        profileMainTest.profileTest();
        profileMainTest.getActiveProfile();
    }
}
