package com.mapei.javatest.test20190104.classfiyAopTest;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/4
 */
public class SleetHelper implements MethodBeforeAdvice,AfterReturningAdvice{
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before Sleeping!");
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("After Sleeping!");
    }
}
