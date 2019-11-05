package com.yht.example1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


class UserRowMapper implements RowMapper<User>{

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        return user;
    }
}

public class Demo3 {
    public static void main(String[] args) {
        ApplicationContext con = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jt = (JdbcTemplate) con.getBean("jdbcTemplate");
        //jt.update("insert into user(name, age) values(?,?)", "ww", 34);
        //jt.update("delete from user where id = ?", 5);
        //jt.update("update user set age = ? where id = ?", 55,4);
//        List<User> users = jt.query("select * from user", new UserRowMapper());
//        List<User> users = jt.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
//        System.out.println(users);
//        List<User> users = jt.query("select * from user where id = ? ", new BeanPropertyRowMapper<User>(User.class), 1);
//        System.out.println(users.isEmpty() ? "not exist" : users.get(0));
        Long count = jt.queryForObject("select count(*) from user", Long.class);
        System.out.println(count);

    }
}
