package com.yht.example1.test;

import com.sun.deploy.net.HttpResponse;
import com.yht.example1.unity.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserTest {

    @RequestMapping("/testString")
    public String testString(Model model){
        User user = new User("tom", "123", 12);
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public String testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("testVoid方法执行……");
        //请求转发
        request.getRequestDispatcher("WEB-INF/pages/success.jsp").forward(request, response);
        //重定向
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        //解决中文乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //直接响应
        response.getWriter().println("hello");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv = new ModelAndView();
        User user = new User("tom", "123", 12);
        mv.addObject("user", user);
        mv.setViewName("success");
        return mv;
    }


    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
//       return "forward:/WEB-INF/pages/success";
        return "redirect:/index.jsp";
    }
}
