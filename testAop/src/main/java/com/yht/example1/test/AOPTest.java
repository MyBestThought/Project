package com.yht.example1.test;

import com.yht.example1.service.IAccount;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        IAccount account = (IAccount) con.getBean("account");
        account.saveAccount();
    }
}
