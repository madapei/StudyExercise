package com.mapei.spring.service;

import com.mapei.spring.service.impl.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/22
 */
@Configuration
public class CdConfig {
    @Bean
    public CompactDisc compactDisc(){
        return new SgtPeppers();
    }
}
