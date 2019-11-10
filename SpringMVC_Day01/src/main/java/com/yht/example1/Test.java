package com.yht.example1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * SpringMVC的入门程序
 *
 */


@Controller
public class Test {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello I am success!!!");
        return "success";
    }
}
