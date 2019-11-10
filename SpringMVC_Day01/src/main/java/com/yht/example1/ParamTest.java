package com.yht.example1;

import com.yht.example1.commons.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/param")
public class ParamTest {

    /**
     * 注入基本数据类型
     * @param name
     * @return
     */
    @RequestMapping("/showName")
    public String showName(String name){
        System.out.println("从页面获取的name值是：" + name);
        return "success";
    }

    @RequestMapping("/showTeacher")
    public String showTeacher(Teacher teacher){
        System.out.println(teacher);
        return "success";
    }


}
