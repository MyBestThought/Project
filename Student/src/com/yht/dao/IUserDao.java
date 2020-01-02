package com.yht.dao;

import com.yht.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IUserDao {
    User findByUserName(String userName);//根据姓名查询用户
    void addUser(User user);//添加用户
    List<User> findList(Map<String, Object> map);//查询用户
    int getTotal(Map<String, Object> map);//获取所有信息
    void updateUser(User user);//更新用户信息
    void deleteUser(String ids);
}
