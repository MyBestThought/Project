package com.yht.service.impl;

import com.yht.dao.IAccountDao;
import com.yht.domain.Account;
import com.yht.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao dao;

    @Override
    public List<Account> findAll() {
        return dao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        dao.saveAccount(account);
    }
}
