package com.yht.service.impl;

import com.yht.dao.IUserDao;
import com.yht.entity.User;
import com.yht.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public User findByUserName(String userName) {

        return userDao.findByUserName(userName);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> findList(Map<String, Object> map) {
        return userDao.findList(map);
    }

    @Override
    public int getTotal(Map<String, Object> map) {
        return userDao.getTotal(map);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(String ids) {
        userDao.deleteUser(ids);
    }
}
