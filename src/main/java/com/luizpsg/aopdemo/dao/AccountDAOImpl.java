package com.luizpsg.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.luizpsg.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

  private String name;
  private String serviceCode;

  @Override
  public void addAccount(Account theAccount, boolean vipFlag) {
    System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT " + (vipFlag ? "VIP" : ""));
  }

  @Override
  public boolean doWork() {
    System.out.println(getClass() + ": doWork()");
    return false;
  }

  public String getName() {
    System.out.println(getClass() + ": in getName()");
    return name;
  }

  public void setName(String name) {
    System.out.println(getClass() + ": in setName()");
    this.name = name;
  }

  public String getServiceCode() {
    System.out.println(getClass() + ": in getServiceCode()");
    return serviceCode;
  }

  public void setServiceCode(String serviceCode) {
    System.out.println(getClass() + ": in setServiceCode()");
    this.serviceCode = serviceCode;
  }

  @Override
  public List<Account> findAccounts() {
    List<Account> myAccounts = new ArrayList<>();

    myAccounts.add(new Account("John", "Silver"));
    myAccounts.add(new Account("Madeline", "Platinum"));
    myAccounts.add(new Account("Luiz", "Gold"));

    return myAccounts;
  }

  @Override
  public List<Account> findAccounts(boolean tripWire) {
    if (tripWire) {
      throw new RuntimeException("No soup for you!!!");
    }

    return findAccounts();
  }
}
