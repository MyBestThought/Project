package com.yht.example1.service.impl;

import com.yht.example1.service.IAccount;

public class AccountImpl implements IAccount {
    public void saveAccount() {
        System.out.println("save success!!!");
    }

    public void updateAccount(int id) {
        System.out.println("uodate success~~~");
    }

    public int deleteAccount() {
        System.out.println("delete success-----");
        return 0;
    }
}
