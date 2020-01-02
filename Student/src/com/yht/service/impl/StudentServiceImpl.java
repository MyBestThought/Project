package com.yht.service.impl;

import com.yht.dao.IStudentDao;
import com.yht.dao.IStudentDao;
import com.yht.entity.Student;
import com.yht.entity.Student;
import com.yht.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao studentDao;

    @Override
    public void addStudent(Student clazz) {
        studentDao.addStudent(clazz);
    }

    @Override
    public List<Student> findList(Map<String, Object> map) {
        return studentDao.findList(map);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public int getTotal(Map<String, Object> map) {
        return studentDao.getTotal(map);
    }

    @Override
    public void updateStudent(Student clazz) {
        studentDao.updateStudent(clazz);
    }

    @Override
    public void deleteStudent(String ids) {
        studentDao.deleteStudent(ids);
    }

    @Override
    public Student findByStudentName(String username) {
        return studentDao.findByStudentName(username);
    }
}
