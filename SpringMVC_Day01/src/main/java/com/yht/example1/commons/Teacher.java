package com.yht.example1.commons;

import java.io.Serializable;
import java.util.*;

public class Teacher implements Serializable {
    private String name;
    private int age;
    private String job;
    private Date birthday;


    private List<Student> list = new ArrayList<>();

    private Map<Integer, Student> map = new HashMap<>();

    public Teacher() {
    }


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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public Map<Integer, Student> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Student> map) {
        this.map = map;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
