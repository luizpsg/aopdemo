package com.luizpsg.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

  // this is where we add all of our related advices for logging

  // lets start with an @Before advice

  // @Before("execution(public void
  // com.luizpsg.aopdemo.dao.AccountDAO.addAccount())")
  // public void beforeAddAccountAdvice() {
  // System.out.println("\n=====>>> Executing @Before advice on AccountDAO
  // addAccount()");
  // }

  // @Before("execution(public void addAccount())")
  // public void beforeAddAccountAdvice() {
  // System.out.println("\n=====>>> Executing @Before advice on any void
  // addAccount()");
  // }

  // @Before("execution(* addAccount())")
  // public void beforeAddAccountAdvice() {
  // System.out.println("\n=====>>> Executing @Before advice on any
  // addAccount()");
  // }

  // @Before("execution(void add*())")
  // public void beforeAddAccountAdvice() {
  // System.out.println("\n=====>>> Executing @Before advice on any void
  // add***()");
  // }

  // @Before("execution(* add*())")
  // public void beforeAddAccountAdvice() {
  // System.out.println("\n=====>>> Executing @Before advice on any add***()");
  // }

  // Now with params //
  // @Before("execution(* add*(com.luizpsg.aopdemo.Account))")
  // public void beforeAddAccountAdvice() {
  // System.out.println("\n=====>>> Executing @Before advice on any add***(With
  // Account param)");
  // }

  // @Before("execution(* add*(com.luizpsg.aopdemo.Account, ..))")
  // public void beforeAddAccountAdvice() {
  // System.out
  // .println("\n=====>>> Executing @Before advice on any add***(With Account
  // param, ..*any number of params)");
  // }

  // @Before("execution(* add*(..))")
  // public void beforeAddAccountAdvice() {
  // System.out
  // .println("\n=====>>> Executing @Before advice on any add***(ANY number of
  // params, and any params type)");
  // }

  @Before("execution(* com.luizpsg.aopdemo.dao.*.*(..))")
  public void beforeAddAccountAdvice() {
    System.out
        .println(
            "\n=====>>> Executing @Before advice on any return type of package dao on any class and any method(ANY number of params, and any params type)");
    // all of this togheter will allow us to match any method in any class in the
    // given package
  }
}
