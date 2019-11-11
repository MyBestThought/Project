package com.yht.example1.commons;


public class User {

    private String uname;
    private String password;
    private int uage;


    public User() {
    }

    public User(String uname, String password, int uage) {
        this.uname = uname;
        this.password = password;
        this.uage = uage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }


    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", uage=" + uage +
                '}';
    }
}
