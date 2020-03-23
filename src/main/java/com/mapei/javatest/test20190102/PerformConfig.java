package com.mapei.javatest.test20190102;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/2
 */
@Configuration
//@EnableAspectJAutoProxy
public class PerformConfig {
    @Bean
    public Performance getDancePerformance(){
        return new DancePerformance();
    }

    @Bean
    public Audience audience(){
        return new Audience();
    }

//    @Bean
//    public EncoreableConfig encoreableConfig(){
//        return new EncoreableConfig();
//    }
}
