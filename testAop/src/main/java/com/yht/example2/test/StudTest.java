package com.yht.example2.test;

import com.yht.example2.common.StudentMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudTest {
    public static void main(String[] args) {
        ApplicationContext con = new ClassPathXmlApplicationContext("bean.xml");
        StudentMessage studentMessage = (StudentMessage) con.getBean("stu");
        studentMessage.saveScore();
//        studentMessage.deleteScore();
//        studentMessage.searchScore(1);
    }
}
