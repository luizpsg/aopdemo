package com.luizpsg.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luizpsg.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyLoggingDemoAspect {

  @Around("execution(* com.luizpsg.aopdemo.service.*.getFortune(..))")
  public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

    // print out the method we are advising on
    String method = theProceedingJoinPoint.getSignature().toShortString();
    System.out.println("\n=====>>> Executing @Around on method: " + method);

    // get begin timestamp
    long begin = System.currentTimeMillis();

    // now, let's execute the method
    Object result = theProceedingJoinPoint.proceed();

    // get end timestamp
    long end = System.currentTimeMillis();

    // compute duration and display it
    long duration = end - begin;
    System.out.println("\n=====>>> Duration: " + duration / 1000.0 + " seconds");

    return result;
  }

  @After("execution(* com.luizpsg.aopdemo.dao.AccountDAO.findAccounts(..))")
  public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

    // print out which method we are advising on
    String method = theJoinPoint.getSignature().toShortString();
    System.out.println("\n=====>>> Executing @After (finally) on method: " + method);

  }

  @AfterThrowing(pointcut = "execution(* com.luizpsg.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
  public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {

    // print out which method we are advising on
    String method = theJoinPoint.getSignature().toShortString();
    System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

    // log the exception
    System.out.println("\n=====>>> The exception is: " + theExc);

  }

  // add a new advice for @AfterReturning on the fundAccounts method
  @AfterReturning(pointcut = "execution(* com.luizpsg.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
  public void AfterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

    // print out which method we are advising on
    String method = theJoinPoint.getSignature().toShortString();
    System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

    // print out the results of the method call
    System.out.println("\n=====>>> result is: " + result);

    // let's post-process the data ... let's modify it

    // convert the account names to uppercase
    convertAccountNamesToUpperCase(result);

    System.out.println("\n=====>>> result is: " + result);

  }

  private void convertAccountNamesToUpperCase(List<Account> result) {

    // convert account names to uppercase using stream
    result.stream()
        .forEach(account -> account.setName(account.getName().toUpperCase()));
  }

  @Before("com.luizpsg.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
  public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
    System.out.println("\n=====>>> Executing @Before advice on addAccount()");

    // display the method signature
    MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();

    System.out.println("Method: " + methodSig);

    // display the method arguments

    // get args
    Object[] args = theJoinPoint.getArgs();

    // loop thru args
    for (Object tempArg : args) {
      System.out.println(tempArg);

      if (tempArg instanceof Account theAccount) {
        System.out.println("account name: " + theAccount.getName());
        System.out.println("account level: " + theAccount.getLevel());
      }
    }
  }

}
