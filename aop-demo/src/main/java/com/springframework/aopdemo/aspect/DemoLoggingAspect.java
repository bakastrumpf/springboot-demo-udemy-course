package com.springframework.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Component
public class DemoLoggingAspect {

    // this is where we all of our related advice for logging

    // starting with @Before advice
    @Before("execution(public void com.springframework.aopdemo.DAO.AccountDAO.addAccount())")
    // @Before("execution(public void updateAccount())")
    public void beforeAddAccountAdvice(){
        System.out.println("\n =====>>> Executing @Before advice on method");
    }
}
