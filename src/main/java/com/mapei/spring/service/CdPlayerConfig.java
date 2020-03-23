package com.mapei.spring.service;

import com.mapei.spring.service.impl.CdPlayerOne;
import com.mapei.spring.service.impl.CdPlayerTwo;
import com.mapei.spring.service.impl.SgtPeppers;
import com.mapei.spring.service.impl.Tfboys;
import org.junit.Test;
import org.springframework.context.annotation.*;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/19
 */
@Configuration
//@Import(CdConfig.class)
@ImportResource("classpath:SpringConfig.xml")
public class CdPlayerConfig {


   /* @Bean
    public CdPlayer cdPlayerOne(){
        return new CdPlayerOne(sgtPeppers());
    }

    @Bean
    public CdPlayer cdPlayerTwo(){
        return new CdPlayerTwo(sgtPeppers());
    }*/

   /* @Bean
    public CdPlayer cdPlayerOne(CompactDisc compactDisc){
        return new CdPlayerOne(compactDisc);
    }

    @Bean
    public CdPlayer cdPlayerTwo(CompactDisc compactDisc){
        return new CdPlayerTwo(compactDisc);
    }*/

}
