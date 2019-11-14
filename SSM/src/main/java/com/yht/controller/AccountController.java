package com.yht.controller;

import com.yht.domain.Account;
import com.yht.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService service;

    @RequestMapping("/searchAll")
    public ModelAndView searchAll(){
        ModelAndView mv = new ModelAndView();
        List<Account> accounts = service.findAll();
        mv.addObject("accounts", accounts);
        System.out.println(accounts);
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/saveAccount")
    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws Exception{
        service.saveAccount(account);
        response.sendRedirect(request.getContextPath() + "/account/searchAll");
        return;
    }
}
