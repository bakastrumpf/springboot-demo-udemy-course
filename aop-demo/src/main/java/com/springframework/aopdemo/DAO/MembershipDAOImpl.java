package com.springframework.aopdemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

//    @Override
//    public void addAccount() {
//        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
//
//    }

    @Override
    public boolean addNewMethod() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT with a NEW METHOD");
        return true;
    }

    @Override
    public boolean goToSleep() {
        System.out.println(getClass() + ": Off to sleep! ");
        return false;
    }
}
