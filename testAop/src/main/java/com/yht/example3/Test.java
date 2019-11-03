package com.yht.example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext con = new ClassPathXmlApplicationContext("bean.xml");
        Teacher teacher = (Teacher) con.getBean("teacher");
        teacher.getMoney();
    }
}
