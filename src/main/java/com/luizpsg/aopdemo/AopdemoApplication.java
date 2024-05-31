package com.luizpsg.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luizpsg.aopdemo.dao.AccountDAO;
import com.luizpsg.aopdemo.dao.MembershipDAO;

@SpringBootApplication
public class AopdemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(AopdemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
    return runner -> {

      // demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);

      demoTheAfterReturningAdvice(theAccountDAO);

      System.out.println("\n");
    };
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
