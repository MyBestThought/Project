package com.yht.example3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("notification")
@Aspect
public class Notification {

    @Pointcut("execution(* com.yht.example3.Teacher.getMoney())")
    private void test(){}

    @Before("test()")
    public void beforeMethod(){
        System.out.println("前置通知开始执行");
    }

    @After("test()")
    public void afterMethod(){
        System.out.println("后置通知开始执行");
    }

    @AfterThrowing("test()")
    public void exceptionMethod(){
        System.out.println("异常通知开始执行");
    }

    @AfterReturning("test()")
    public void finalMethod(){
        System.out.println("最终通知开始执行");
    }

    @Around("test()")
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
