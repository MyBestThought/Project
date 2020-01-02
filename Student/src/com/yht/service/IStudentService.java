package com.yht.service;


import com.yht.entity.Clazz;
import com.yht.entity.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    void addStudent(Student student);
    List<Student> findList(Map<String, Object> map);
    List<Student> findAll();
    int getTotal(Map<String, Object> map);
    void updateStudent(Student student);
    void deleteStudent(String ids);


    Student findByStudentName(String username);
}
