package com.mapei.javatest.test20190104.classfiyAopTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassifyAopMainTest {
    public static void main(String[] args) {
        /**
         * 该测试没有成功
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("classifyAop-context.xml");
        Sleepable sleepable =  context.getBean(Human.class);
        sleepable.sleep();
    }
}
