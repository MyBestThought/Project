package com.yht.example3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class TestInterceptor {

    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("hello ");
        return "success";
    }
}
