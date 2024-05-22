package com.luizpsg.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

  // this is where we add all of our related advices for logging

  // lets start with an @Before advice

  // @Before("execution(* add*())")
  // public void beforeAddAccountAdvice() {
  // System.out.println("\n=====>>> Executing @Before advice on addAccount()");
  // }

  // @Before("execution(* addAccount())")
  // public void beforeAddAccountAdvice() {
  // System.out.println("\n=====>>> Executing @Before advice on addAccount()");
  // }

  // @Before("execution(public void
  // com.luizpsg.aopdemo.dao.AccountDAO.addAccount())")
  // public void beforeAddAccountAdvice() {
  // System.out.println("\n=====>>> Executing @Before advice on addAccount()");
  // }

  @Before("execution(public void add*())")
  public void beforeAddAccountAdvice() {
    System.out.println("\n=====>>> Executing @Before advice on addAccount()");
  }

}
