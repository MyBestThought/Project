package com.yht.example1;

import com.yht.example1.commons.Student;
import com.yht.example1.commons.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
public class AnnoTest {

    /**
     * RequestParam：把请求参数中指定的值传给控制器的形参赋值
     * 常用属性：
     * value：请求参数中的名称
     * required：请求参数中是否必须提供此参数，默认值：true，如果不提供，将报错
     * @param username
     * @return
     */

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name="name")String username){
        System.out.println(username);
        return "success";
    }

    /**
     * RequestBody：用于获取请求体中的内容，直接得到的是key=value&key=value...结构的数据
     * get请求方式不适用
     * 属性：
     * required：是否必须有请求体，默认值是：true，当取值为true时，get请求方式会报错，如果取值为false，get请求方式为null
     * @return
     */

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String msg){
        System.out.println(msg);
        return "success";
    }

    /**
     * PathVariable：用于绑定url的占位符。例如：请求url的/delete/{id}，这个{id}就是占位符。
     * url支持占位符是Spring3.0之后引入的，是支持restful风格的重要标志
     * 属性：
     * value：用于指定url中占位符的名称
     * required：是否必须提供占位符
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(value = "id") String id){
        System.out.println(id);
        return "success";
    }

    /**
     * RequestHeader：用于获取请求消息头
     * 属性：
     * value：提供消息头名称
     * required：是否必须有消息头
     * @param msg
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(name = "Accept") String msg){
        System.out.println(msg);
        return "success";
    }

    /**
     * CookieValue：用于把指定cookie的名称的值传递给控制器的方法参数
     * value：提供消息头名称
     * required：是否必须有cookie
     * @param msg
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String msg){
        System.out.println(msg);
        return "success";
    }

    /**
     * ModelAttribute：用于修饰方法或者参数
     *  出现在方法上，表示当前方法会在控制器的方法之前执行，可以修饰没有返回值和有返回值的方法。
     *  出现在参数上，获取指定的数据给参数赋值
     *  属性：
     *  value：用于获取数据的key
     *  应用场景：
     *  当表单提交数据不完整时，保证没有提交的数据字段仍然有值
     *
     * @param user
     * @return
     */

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("aa") User user){
        System.out.println("我是testModelAttribute方法");
        System.out.println(user);
        return "success";
    }

    @ModelAttribute
    public void showUser(String uname, Map<String, User> map){
        System.out.println("我是showUser方法");
        User user = new User();
        user.setUname(uname);
        user.setPassword("234");
        user.setUage(12);
        map.put("aa", user);
    }

//    @ModelAttribute
//    public User showUser(String uname){
//        System.out.println("我是showUser方法");
//        User user = new User();
//        user.setUname(uname);
//        user.setPassword("234");
//        user.setUage(12);
//        return user;
//    }

}
