package com.springframework.aopdemo.aspect;

import com.springframework.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Aspect
@Component
@Order(3)
public class DemoLoggingAspect {

    // add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.springframework.aopdemo.DAO.AccountDAO.findAccounts(..))",
            returning = "result")
    public void  afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n\n=====>>>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n\n=====>>>>> result: " + result);

        // post-process the data to modify it
        // convert the account names to uppercase
        convertAccountNamesToUppercase(result);

        // print out the results of the method call
        System.out.println("\n\n=====>>>>> post-modified result: " + result);

    }

    private void convertAccountNamesToUppercase(List<Account> result) {

        // loop through accounts
        for (Account tempAccount : result) {

            // get uppercase version of name
            String theUppercaseName = tempAccount.getName().toUpperCase();

            // update the name of the account
            tempAccount.setName(theUppercaseName);

        }



    }

/*
    // this is where we all of our related advice for logging
    // starting with @Before advice
    // then @Pointcut
    // @JoinPoints
    // @AfterReturning
    // @AfterThrowing
    // @After
    // @Around

    @Pointcut("execution(* com.springframework.aopdemo.DAO.*.*())")
    private void forDaoPackage(){}

    // create pointcut for getters
    @Pointcut("execution(* com.springframework.aopdemo.DAO.*.get*())")
    private void getter(){}

    // create pointcut for setter
    @Pointcut("execution(* com.springframework.aopdemo.DAO.*.set*())")
    private void setter(){}

    // combine pointcut to include package and exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}
*/

    // @Before("execution(public void com.springframework.aopdemo.DAO.AccountDAO.addAccount())")
    // @Before("execution(public void updateAccount())")
    // @Before("execution(public void add*())")
    // @Before("execution(* add*(Account))")
    // @Before("execution(* add*(com.springframework.aopdemo.Account))")
    // @Before("execution(* add*(com.springframework.aopdemo.Account, ..))")
    // @Before("execution(* com.springframework.aopdemo.DAO.*.*(..))")
    // @Before("forDaoPackage()")
    @Before("com.springframework.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n =====>>> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments

        //  get args
        Object[] args = theJoinPoint.getArgs();

        // loop through the args and print them out
        for(Object tempArg : args){
            System.out.println(tempArg);
            if (tempArg instanceof Account){
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("Account name: " + theAccount.getName());
                System.out.println("Account name: " + theAccount.getLevel());
            }
        }
    }


/*
    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n =====>>> New API Analytics");
    }

    @Before("forDaoPackage()")
    public void logToCloudAsync(){
        System.out.println("\n =====>>> Logging to cloud in async fashion");
    }

*/
}
