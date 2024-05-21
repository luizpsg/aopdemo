package com.luizpsg.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luizpsg.aopdemo.dao.AccountDAO;

@SpringBootApplication
public class AopdemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(AopdemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {
    return runner -> {

      demoTheBeforeAdvice(theAccountDAO);
    };
  }

  private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {

    // call the business method
    theAccountDAO.addAccount();
  }

}