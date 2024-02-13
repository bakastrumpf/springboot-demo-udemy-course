package com.springframework.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CloudLoggingAspect {

    @Before("com.springframework.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void logToCloudAsync(){
        System.out.println("\n =====>>> Logging to cloud in async fashion");
    }
}
