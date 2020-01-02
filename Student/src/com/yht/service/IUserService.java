package com.yht.service;

import com.yht.entity.User;

import java.util.List;
import java.util.Map;


public interface IUserService {
    User findByUserName(String userName);
    void addUser(User user);
    List<User> findList(Map<String, Object> map);
    int getTotal(Map<String, Object> map);
    void updateUser(User user);
    void deleteUser(String ids);
}
