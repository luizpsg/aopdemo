package com.luizpsg.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
