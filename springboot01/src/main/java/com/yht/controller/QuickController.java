package com.yht.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@ConfigurationProperties(prefix = "student")
public class QuickController {
    //@Value("${student.name}")
    private String name;
    //@Value("${student.age}")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @RequestMapping("/hello")

    public String sayHello(){
        return "Everything will be ok!!!aaa";
    }

    @RequestMapping("/msg1")
    public String getMessage1(){
        return this.name + this.age;
    }
    @RequestMapping("/msg2")
    public String getMessage2(){
        return this.getName() + this.getAge();
    }
}
