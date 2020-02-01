package com.dao;

import com.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface IStudentDao {
    List<Student> findAll();
}
