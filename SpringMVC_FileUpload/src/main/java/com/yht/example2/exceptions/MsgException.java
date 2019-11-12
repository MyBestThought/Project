package com.yht.example2.exceptions;

//自定义异常类
public class MsgException extends Exception{
    private String message;

    public MsgException(){}

    public MsgException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
