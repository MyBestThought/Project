package com.yht.controller;

import com.mysql.jdbc.StringUtils;
import com.yht.entity.Student;
import com.yht.entity.User;
import com.yht.service.IStudentService;
import com.yht.service.IUserService;
import com.yht.utils.CpachaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆页面的逻辑实现：用户名、密码以及验证码的校验
 *
 */

@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IStudentService studentService;

    /**
     * 测试SSM框架
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }

    /**
     * 验证码的生成实现
     * @param request
     * @param vl   验证码的字符数
     * @param w    验证码的整体宽度
     * @param h    验证码的高度
     * @param response
     */
    @RequestMapping(value="/getCheckCode", method=RequestMethod.GET)
    public void getCheckCode(HttpServletRequest request,
                             @RequestParam(value="vl", defaultValue = "4",required = false) Integer vl,
                             @RequestParam(value="W", defaultValue = "98",required = false) Integer w,
                             @RequestParam(value="H", defaultValue = "33",required = false) Integer h,
                             HttpServletResponse response){
        CpachaUtil cpachaUtil = new CpachaUtil(vl, w, h);
        String generatorVCode = cpachaUtil.generatorVCode();
        request.getSession().setAttribute("loginCpacha", generatorVCode);
        BufferedImage bufferedImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
        try {
            ImageIO.write(bufferedImage, "gif", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 由index.jsp页面转到views/system.index.jsp页面，进入系统管理员首页---
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/system/index");
        return modelAndView;
    }

    /**
     * 显示系统登录页面
     * @param model
     * @return
     */
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelAndView model){
        return "system/login";
    }

    /**
     * 用户登录检验，对用户名、密码和验证码进行校验。
     * 复选框的选择不同，转发的页面不同
     *
     * @param username  用户名
     * @param password  密码
     * @param vcode     验证码
     * @param type      身份
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> login(
            @RequestParam(value="username", required = true) String username,
            @RequestParam(value="password", required = true) String password,
            @RequestParam(value="vcode", required = true) String vcode,
            @RequestParam(value="type", required = true) int type,
            HttpServletRequest request
    ){

        Map<String, String> map = new HashMap<>();
//        if(username == null || username.isEmpty()){
//            map.put("type", "error");
//            map.put("msg", "用户名不能为空");
//            return map;
//        }
//        if(password == null || password.isEmpty()){
//            map.put("type", "error");
//            map.put("msg", "密码不能为空");
//            return map;
//        }
//        if(vcode == null || vcode.isEmpty()){
//            map.put("type", "error");
//            map.put("msg", "验证码不能为空");
//            return map;
//        }

        String loginCode = (String) request.getSession().getAttribute("loginCpacha");
        if(loginCode == null || loginCode.isEmpty()){
            map.put("type", "error");
            map.put("msg", "请刷新后重试");
            return map;
        }

        if(!vcode.toUpperCase().equals(loginCode.toUpperCase())){
            map.put("type", "error");
            map.put("msg", "验证码错误");
            return map;
        }
        request.getSession().setAttribute("loginCpacha", null);

        //身份甄别
        if(type == 1){
            //管理员
            User user = userService.findByUserName(username);
            if(user == null){
                map.put("type", "error");
                map.put("msg", "当前用户不存在");
            }
            if(!user.getPassword().equals(password)){
                map.put("type", "error");
                map.put("msg", "密码错误");
            }
            request.getSession().setAttribute("user", user);
        }
        if(type == 2){
            //学生
            Student student = studentService.findByStudentName(username);
            if(student == null){
                map.put("type", "error");
                map.put("msg", "不存在该学生!");
                return map;
            }
            if(!password.equals(student.getPassword())){
                map.put("type", "error");
                map.put("msg", "密码错误!");
                return map;
            }
            request.getSession().setAttribute("user", student);
        }
        request.getSession().setAttribute("userType", type);
        map.put("type", "success");
        map.put("msg", "验证通过");
        return map;
    }

    /**
     * 注销登录
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginOut",method=RequestMethod.GET)
    public String loginOut(HttpServletRequest request){
        request.getSession().setAttribute("user", null);
        return "redirect:login";
    }
}
