package com.mapei.javatest.test20181226;

import org.springframework.context.annotation.*;
import org.springframework.context.event.SourceFilteringListener;
import org.springframework.stereotype.Component;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/26
 */
@Configuration
@ComponentScan(basePackages = "com.mapei.javatest.test20181226")
public class DataSourceConfig {
//    @Bean
//    public MySql getMysql(){
//        return new MySql();
//    }

//    @Bean
//    public DbType getOracle(){
//        return new Oracle();
//    }

    @Bean
    public DevDataSource devDataSource(){
        return new DevDataSource();
    }
//
//    @Bean
//    public DataSource qaDataSource(MySql mySql){
//        return new QaDataSource(mySql);
//    }


//    @Bean
//    public QaDataSource qaDataSource(MySql mySql){
//        return new QaDataSource(mySql);
//    }


//    @Bean
////    @Conditional(DataSourceCondition.class)
//    public OnlineDataSource onlineDataSource(){
//        return new OnlineDataSource(dbType());
//    }
//

}
