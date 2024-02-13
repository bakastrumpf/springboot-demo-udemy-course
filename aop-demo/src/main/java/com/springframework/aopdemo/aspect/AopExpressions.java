package com.springframework.aopdemo.aspect;

// utility class to hold aspects

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// @Aspect annotation is optional if we only have pointcuts
// @Aspect annotation is required with @Before, @After, etc.
@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.springframework.aopdemo.DAO.*.*())")
    public void forDaoPackage(){}

    // create pointcut for getters
    @Pointcut("execution(* com.springframework.aopdemo.DAO.*.get*())")
    public void getter(){}

    // create pointcut for setter
    @Pointcut("execution(* com.springframework.aopdemo.DAO.*.set*())")
    public void setter(){}

    // combine pointcut to include package and exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}


}
