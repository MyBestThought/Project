package com.yht.example2.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggerMessage {

    public void beforeMethod(){
        System.out.println("前置通知开始执行");
    }

    public void afterMethod(){
        System.out.println("后置通知开始执行");
    }

    public void exceptionMethod(){
        System.out.println("异常通知开始执行");
    }

    public void finalMethod(){
        System.out.println("最终通知开始执行");
    }

    public Object arroundMethod(ProceedingJoinPoint pjp){
        System.out.println("没错，我是环绕通知");
        Object reValue = null;
        try{
            Object[] args = pjp.getArgs();
            System.out.println("----前置通知----");
            reValue = pjp.proceed(args);
            System.out.println("----后置通知----");
            return reValue;
        }catch(Throwable t){
            System.out.println("----异常通知----");
            throw new RuntimeException();
        }finally{
            System.out.println("----最终通知----");
        }

    }
}
