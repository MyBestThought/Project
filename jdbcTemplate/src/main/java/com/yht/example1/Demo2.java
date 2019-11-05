package com.yht.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Demo2 {
    public static void main(String[] args) {
        ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jt = (JdbcTemplate) con.getBean("jdbcTemplate");
        jt.execute("insert into user(name, age) values('ls', 14)");
    }
}
