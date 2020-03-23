package com.mapei.javatest.test20181226;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2018/12/27
 */
public class DataSourceCondition implements Condition{
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String value = context.getEnvironment().getProperty("testName");
        if (value != null && "mapei".equals(value)){
            return true;
        }
        return false;
    }
}
