package com.yht.service;

import com.yht.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    void saveAccount(Account account);
}
