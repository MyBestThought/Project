package com.yht.interceptor;

import com.yht.entity.User;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录拦截器
 */

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String url = request.getRequestURI();
        System.out.println(url);
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            System.out.println("登陆失败");
            if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
                Map<String, String> map = new HashMap<>();
                map.put("type", "error");
                map.put("msg", "登陆状态已经失效");
                response.getWriter().write(JSONObject.fromObject(map).toString());
                return false;
            }
            response.sendRedirect(request.getContextPath() + "/system/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
