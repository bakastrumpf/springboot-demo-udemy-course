package com.springframework.aopdemo.DAO;

import com.springframework.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

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

//    @Override
//    public void addAccount() {
//        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
//
//    }

    @Override
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account tempAccount1 = new Account("Customer 1", "Basic");
        Account tempAccount2 = new Account("Customer 2", "Super");
        Account tempAccount3 = new Account("Customer 3", "Premium");

        // add accounts to our accounts list
        myAccounts.add(tempAccount1);
        myAccounts.add(tempAccount2);
        myAccounts.add(tempAccount3);

        return myAccounts;
    }

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    @Override
    public boolean doWork() {

        System.out.println(getClass() + ": doWork()");
        return false;
    }
}
