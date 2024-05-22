package com.luizpsg.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingDemoAspect {

  @Before("com.luizpsg.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
  public void beforeAddAccountAdvice() {
    System.out.println("\n=====>>> Executing @Before advice on addAccount()");
  }

}
