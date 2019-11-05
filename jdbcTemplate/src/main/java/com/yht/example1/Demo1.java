package com.yht.example1;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Demo1 {
    public static void main(String[] args) {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/数据库的名称");
        ds.setUsername("数据库的用户名");
        ds.setPassword("数据库的密码");
        JdbcTemplate jt = new JdbcTemplate(ds);
        jt.execute("insert into user(name, age) values('zs', 23)");
    }
}
