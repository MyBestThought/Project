package com.yht.example3;

import org.springframework.stereotype.Component;

@Component("teacher")
public class Teacher {
    public void getMoney(){
        System.out.println("得到工资");
    }

    public void studentMessage(){
        System.out.println("录入学生成绩");
    }
}
