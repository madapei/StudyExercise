package com.mapei.javatest.test20181228;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/28
 */
@Configuration
@ComponentScan(basePackages = "com.mapei.javatest.test20181228")
public class TestConfig {
    @Bean
    public UsepRrototype usepRrototypeOne(ProtoTypeTest protoTypeTest){
        return new UsepRrototype(protoTypeTest);
    }

    @Bean
    public UsepRrototype usepRrototypeTwo(ProtoTypeTest protoTypeTest){
        return new UsepRrototype(protoTypeTest);
    }

}
