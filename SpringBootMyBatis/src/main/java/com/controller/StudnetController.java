package com.controller;

import com.dao.IStudentDao;
import com.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudnetController {

    @Autowired
    private IStudentDao studentDao;
    @RequestMapping("/findAll")
    @ResponseBody
    public List<Student> findAll(){
        return studentDao.findAll();
    }
}
