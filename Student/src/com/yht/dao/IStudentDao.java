package com.yht.dao;

import com.yht.entity.Student;
import com.yht.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IStudentDao {
    void addStudent(Student student);
    List<Student> findList(Map<String, Object> map);
    int getTotal(Map<String, Object> map);
    void updateStudent(Student student);
    void deleteStudent(String ids);
    Student findByStudentName(String username);
    List<Student> findAll();
}
