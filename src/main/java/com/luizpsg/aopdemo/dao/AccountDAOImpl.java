package com.luizpsg.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.luizpsg.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

  @Override
  public void addAccount(Account theAccount, boolean vipFlag) {
    System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT " + (vipFlag ? "VIP" : ""));
  }

  @Override
  public boolean doWork() {
    System.out.println(getClass() + ": doWork()");
    return false;
  }
}
