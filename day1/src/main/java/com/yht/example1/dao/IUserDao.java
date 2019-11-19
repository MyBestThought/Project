package com.yht.example1.dao;

import com.yht.example1.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

//    @Select("SELECT * FROM USER")
//    List<User> findAll();
}
