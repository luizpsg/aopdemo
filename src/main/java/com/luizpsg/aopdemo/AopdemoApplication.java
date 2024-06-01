package com.luizpsg.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luizpsg.aopdemo.dao.AccountDAO;
import com.luizpsg.aopdemo.dao.MembershipDAO;
import com.luizpsg.aopdemo.service.TrafficFortuneService;

@SpringBootApplication
public class AopdemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(AopdemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO,
      TrafficFortuneService theTrafficFortuneService) {
    return runner -> {

      // demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);

      // demoTheAfterReturningAdvice(theAccountDAO);

      // demoTheAfterThrowingAdvice(theAccountDAO);

      // demoTheAfterAdvice(theAccountDAO);

      // demoTheAroundAdvice(theTrafficFortuneService);

      demoTheAroundAdviceHandleException(theTrafficFortuneService);

      System.out.println("\n");
    };
  }

  private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

    System.out.println("\nMain Program: demoTheAroundAdviceHandleException");

    System.out.println("Calling getFortune");

    boolean tripWire = true;

    String data = theTrafficFortuneService.getFortune(tripWire);

    System.out.println("\nMy fortune is: " + data);

    System.out.println("Finished");
  }

  private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

    System.out.println("\nMain Program: AroundDemoApp");

    System.out.println("Calling getFortune");

    String data = theTrafficFortuneService.getFortune();

    System.out.println("\nMy fortune is: " + data);

    System.out.println("Finished");

  }

  private void demoTheAfterAdvice(AccountDAO theAccountDAO) {

    // call method to fint the accounts
    List<Account> theAccounts = null;

    try {
      // add a boolean flag to simulate exceptions
      boolean tripWire = false;

      theAccounts = theAccountDAO.findAccounts(tripWire);

    } catch (Exception e) {
      System.out.println("\n\nMain Program ... caught exception: " + e);
    }

    // display the accounts
    System.out.println("\n\nMain Program: AfterThrowingAdvice");
    System.out.println("----");
    System.out.println(theAccounts);
  }

  private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

    // call method to fint the accounts
    List<Account> theAccounts = null;

    try {
      // add a boolean flag to simulate exceptions
      boolean tripWire = true;

      theAccounts = theAccountDAO.findAccounts(tripWire);

    } catch (Exception e) {
      System.out.println("\n\nMain Program ... caught exception: " + e);
    }

    // display the accounts
    System.out.println("\n\nMain Program: AfterThrowingAdvice");
    System.out.println("----");
    System.out.println(theAccounts);

  }

  private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

    // call method to fint the accounts
    List<Account> theAccounts = theAccountDAO.findAccounts();

    // display the accounts
    System.out.println("\n\nMain Program: AfterReturningDemoApp");
    System.out.println("----");
    System.out.println(theAccounts);

  }

  private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO MembershipDAO) {

    // create an account
    Account myAccount = new Account();
    myAccount.setName("Luiz Paulo");
    myAccount.setLevel("Infinity");

    // call the Account business methods
    theAccountDAO.addAccount(myAccount, true);
    theAccountDAO.doWork();

    // call the accountdao getter/setter methods
    theAccountDAO.setName("foobar");
    theAccountDAO.setServiceCode("silver");

    String name = theAccountDAO.getName();
    String code = theAccountDAO.getServiceCode();

    System.out.println("Name: " + name + " Code: " + code);

    // call the Membership business methods
    MembershipDAO.addMember();
    MembershipDAO.goToSleep();

  }

}
