package com.springframework.boot.cruddemoproject.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.springframework.boot.cruddemoproject.controller.*.*(..))")
    private void forControllerPackage() {}

    // setup pointcut declarations for service
    @Pointcut("execution(* com.springframework.boot.cruddemoproject.service.*.*(..))")
    private void forServicePackage() {}

    // setup pointcut declarations for dao
    @Pointcut("execution(* com.springframework.boot.cruddemoproject.dao.*.*(..))")
    private void forDaoPackage() {}

}
