package com.springframework.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Component
public class DemoLoggingAspect {

    // this is where we all of our related advice for logging

    // starting with @Before advice

    @Pointcut("execution(* com.springframework.aopdemo.DAO.*.*())")
    private void forDaoPackage(){}

    @Before("forDaoPackage()")
    public void performApiAnalytics(){

    }

    // @Before("execution(public void com.springframework.aopdemo.DAO.AccountDAO.addAccount())")
    // @Before("execution(public void updateAccount())")
    // @Before("execution(public void add*())")
    // @Before("execution(* add*(Account))")
    // @Before("execution(* add*(com.springframework.aopdemo.Account))")
    // @Before("execution(* add*(com.springframework.aopdemo.Account, ..))")
    // @Before("execution(* com.springframework.aopdemo.DAO.*.*(..))")
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n =====>>> Executing @Before advice on method");
    }
}
