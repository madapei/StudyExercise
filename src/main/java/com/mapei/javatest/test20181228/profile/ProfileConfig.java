package com.mapei.javatest.test20181228.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/28
 */
@Configuration
public class ProfileConfig {
    @Autowired
    Environment environment;

    @Bean
    @Profile("dev")
    public ProfileReturn devProfile(){
        return new DevProfile();
    }

    @Bean
    @Profile("online")
    public ProfileReturn onlineProfile(){
        return new OnlineProfile();
    }

    public void printActiveProfile(){
        System.out.println(environment.getActiveProfiles()[0]);
    }

    public boolean testAcceptProfile(String profile){
        return environment.acceptsProfiles(profile);
    }
}
