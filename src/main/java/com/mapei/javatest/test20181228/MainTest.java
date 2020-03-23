package com.mapei.javatest.test20181228;

import com.mapei.javatest.test20181228.profile.ProfileConfig;
import com.mapei.javatest.test20181228.profile.ProfileReturn;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.jws.soap.SOAPBinding;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/28
 */
public class MainTest {
    private ApplicationContext context;

    public void init(){
        context = new AnnotationConfigApplicationContext(TestConfig.class, ResourceConfig.class);
    }

    public static void main(String[] args) {
        MainTest test = new MainTest();
        test.init();
        test.profileAndEnviroment();
    }

    public void prototypeTest(){
        UsepRrototype usepRrototypeOne = (UsepRrototype)context.getBean("usepRrototypeOne");
        usepRrototypeOne.print();
        UsepRrototype usepRrototypeTwo = (UsepRrototype)context.getBean("usepRrototypeTwo");
        usepRrototypeTwo.print();
    }

    public void resourcePropertyTest(){
        //会报错
//        Person person = (Person) context.getBean("getPersonOther");
        Person person = (Person) context.getBean("getPerson");
        person.printPerson();
        /*ResourceConfig config = context.getBean(ResourceConfig.class);
        config.readValue();*/
    }

    public void profileAndEnviroment(){
        ProfileReturn profileReturn = context.getBean(ProfileReturn.class);
        profileReturn.printProfile();
    }
}
