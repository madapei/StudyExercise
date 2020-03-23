package com.mapei.javatest.test20181228;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/28
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProtoTypeTest {
    public void printHash(){
        System.out.println("prototypeTestHash:" + this.hashCode());
    }
}
