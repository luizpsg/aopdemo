package com.luizpsg.aopdemo.dao;

import java.util.List;

import com.luizpsg.aopdemo.Account;

public interface AccountDAO {

  List<Account> findAccounts();

  List<Account> findAccounts(boolean tripWire);

  void addAccount(Account theAccount, boolean vipFlag);

  boolean doWork();

  String getName();

  void setName(String name);

  String getServiceCode();

  void setServiceCode(String serviceCode);

}
