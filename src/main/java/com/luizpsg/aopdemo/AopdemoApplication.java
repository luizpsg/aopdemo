package com.luizpsg.aopdemo;

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

      demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
    };
  }

  private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO MembershipDAO) {

    // call the business method
    theAccountDAO.addAccount();

    // call the Membership business method
    MembershipDAO.addMember();
  }

}
