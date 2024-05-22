package com.luizpsg.aopdemo.dao;

import com.luizpsg.aopdemo.Account;

public interface AccountDAO {
  void addAccount(Account theAccount, boolean vipFlag);

  boolean doWork();
}
