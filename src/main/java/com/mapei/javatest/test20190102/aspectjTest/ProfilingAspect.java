package com.mapei.javatest.test20190102.aspectjTest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Author: MaPei
 * @Description:
 * @Date: Created in 2019/1/3
 */
@Aspect
public class ProfilingAspect {
    @Pointcut("execution(* com.mapei.javatest.test20190102.aspectjTest.*.*(..))")
    public void modelLayer() {
    }

    @Around("modelLayer()")
    public Object logProfile(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        System.out.println("[ProfilingAspect]方法: 【" + joinPoint.getSignature() + "】结束，用时: " + (System.currentTimeMillis() - start));

        return result;
    }
}
