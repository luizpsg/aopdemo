package com.luizpsg.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyLoggingDemoAspect {

  @Before("forDaoPackageNoGetterSetter()")
  public void beforeAddAccountAdvice() {
    System.out.println("\n=====>>> Executing @Before advice on addAccount()");
  }

}
