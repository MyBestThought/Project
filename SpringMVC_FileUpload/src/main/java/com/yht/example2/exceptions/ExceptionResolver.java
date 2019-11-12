package com.yht.example2.exceptions;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class ExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        MsgException ex = null;
        if(ex instanceof Exception){
            ex = (MsgException) e;
        }else{
            ex = new MsgException("系统错误");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", ex.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
