package com.mapei.javatest.test20181226;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/26
 */
public class DataSourceTest {

    private DataSource dataSource;

    private ApplicationContext annoContext;


//    private ApplicationContext xmlContext;

    public void init(){
        try {
//            xmlContext = new ClassPathXmlApplicationContext("spring-context.xml");
            annoContext = new AnnotationConfigApplicationContext(DataSourceConfig.class, DbTypeConfig.class);
        } catch (BeansException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        DataSourceTest t = new DataSourceTest();
        t.init();
        t.annoTest();
    }

    public void annoTest(){
//        DataSource dataSource = annoContext.getBean(DataSource.class);
//        dataSource.start();
//        DbType dbType = annoContext.getBean(DbType.class);
//        System.out.println(dbType);
        DevDataSource dev = annoContext.getBean(DevDataSource.class);
        dev.start();
    }

//    public void xmlTest(){
//        DbType dbType = xmlContext.getBean(Oracle.class);
//        System.out.println(dbType.getDbType());
//    }


}
