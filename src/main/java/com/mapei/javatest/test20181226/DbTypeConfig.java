package com.mapei.javatest.test20181226;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/27
 */
@Configuration
public class DbTypeConfig {
//    @Bean
//    public DbType getOracle(){
//        return new Oracle();
//    }

    @Bean
    @Qualifier("one")
    public MySql dbTypes(){
        return new MySql();
    }

    @Bean
    @Qualifier("other")
    public MySql otherDbType(){
        return new MySql();
    }
}
