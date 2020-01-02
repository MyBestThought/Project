package com.yht.controller;

import com.yht.entity.User;
import com.yht.page.Page;
import com.yht.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 *  管理员的功能实现
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 返回用户列表页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public ModelAndView list(ModelAndView model){
        model.setViewName("/user/userList");
        return model;
    }

    /**
     * 查询所有用户/根据搜索框的输入查找用户
     * @param username  用户名
     * @param page      分页显示
     * @return
     */
    @RequestMapping(value = "/getList")
    @ResponseBody
    public Map<String, Object> getList(
            @RequestParam(value = "username", required = false, defaultValue = "") String username,
            Page page
    ){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("username", "%" + username +"%");
        queryMap.put("offset", page.getOffset());
        queryMap.put("pageSize", page.getRows());
        map.put("rows", userService.findList(queryMap));
        map.put("total", userService.getTotal(queryMap));
        return map;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Map<String, String> add(User user){
        Map<String, String> map = new HashMap<>();
        if(user == null){
            map.put("type", "error");
            map.put("msg", "数据绑定出错，请联系管理员！！！");
            return map;
        }
        if(user.getUsername() == null || user.getUsername().isEmpty()){
            map.put("type", "error");
            map.put("msg", "用户名不能为空！！！");
            return map;
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()){
            map.put("type", "error");
            map.put("msg", "密码不能为空！！！");
            return map;
        }
        System.out.println(user);
//        User exitUser = userService.findByUserName(user.getUsername());
//        if(exitUser.getUsername().equals(user.getUsername())){
//            System.out.println("1111");
//            map.put("type", "error");
//            map.put("msg", "当前用户名已经0存在，请重新输入！！！");
//            return map;
//        }else{
//            System.out.println("2222");
//            userService.addUser(user);
//            map.put("type", "success");
//            map.put("msg", "添加成功");
//            return map;
//        }
        userService.addUser(user);
        map.put("type", "success");
        map.put("msg", "添加成功");
        return map;
    }


    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public Map<String, String> edit(User user){
        Map<String, String> map = new HashMap<>();
        if(user.getUsername() == null || user.getUsername().isEmpty()){
            map.put("type", "error");
            map.put("msg", "用户名不能为空！！！");
            return map;
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()){
            map.put("type", "error");
            map.put("msg", "密码不能为空！！！");
            return map;
        }
//        User exitUser = userService.findByUserName(user.getUsername());
//        if(exitUser != null){
//            if(user.getId() != exitUser.getId()){
//                map.put("type", "error");
//                map.put("msg", "修改失败");
//                return map;
//            }
//        }

        userService.updateUser(user);
        map.put("type", "success");
        map.put("msg", "修改成功");
        return map;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public Map<String, String> delete(
            @RequestParam(value = "ids[]", required = true) Long[] ids
    ){
        Map<String, String> map = new HashMap<>();
        if(ids == null){
            map.put("type", "error");
            map.put("msg", "请选择要删除的数据！！！");
            return map;
        }
        String idsString = "";
        for(Long id : ids){
            idsString += id + ",";
        }
        idsString = idsString.substring(0, idsString.length()-1);
        userService.deleteUser(idsString);
        map.put("type", "success");
        map.put("msg", "删除成功");
        return map;
    }
}
