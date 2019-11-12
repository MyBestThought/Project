package com.yht.example2;

import com.yht.example2.exceptions.MsgException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/errors")
public class ErrorTest {

    /**
     * 编写自定义异常类
     * 编写异常处理器
     * 配置异常处理器
     * @return
     * @throws MsgException
     */

    @RequestMapping("/testException")
    public String testException() throws MsgException {
        try {
            int a = 10 / 0;
        } catch (Exception e) {
            throw new MsgException("查询失败");
        }
        return "success";
    }
}
