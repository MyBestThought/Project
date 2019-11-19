package com.yht.example1.dao.impl;

import com.yht.example1.dao.IUserDao;
import com.yht.example1.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private SqlSessionFactory sessionFactory;

    public UserDaoImpl(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> findAll() {
        SqlSession session = sessionFactory.openSession();
        List<User> list = session.selectList("com.yht.example1.dao.IUserDao.findAll");
        session.close();
        return list;
    }
}
