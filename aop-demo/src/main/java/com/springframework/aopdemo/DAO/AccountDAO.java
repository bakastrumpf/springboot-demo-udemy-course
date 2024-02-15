package com.springframework.aopdemo.DAO;

import com.springframework.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    // add a new method findAccounts()
    List<Account> findAccounts();

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);

}
