package com.yht.controller;

import com.yht.entity.Grade;
import com.yht.page.Page;
import com.yht.service.IGradeService;
import com.yht.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/grade")
@Controller
public class GradeController {

    @Autowired
    private IGradeService gradeService;

    @RequestMapping(value = "/list")
    public String list(){
        return "/grade/gradeList";
    }

    @RequestMapping(value = "/getList")
    @ResponseBody
    public Map<String, Object> getList(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            Page page
    ){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("name", "%" + name +"%");
        queryMap.put("offset", page.getOffset());
        queryMap.put("pageSize", page.getRows());
        map.put("rows", gradeService.findList(queryMap));
        map.put("total", gradeService.getTotal(queryMap));
        return map;
    }


    @RequestMapping(value = "/add")
    @ResponseBody
    public Map<String, String> add(Grade grade){
        Map<String, String> map = new HashMap<>();
        if(grade == null){
            map.put("type", "error");
            map.put("msg", "添加失败！！！");
            return map;
        }
        if(grade.getName() == null || grade.getName().isEmpty()){
            map.put("type", "error");
            map.put("msg", "年级名称不能为空！！！");
            return map;
        }
        System.out.println(grade);

        gradeService.addGrade(grade);
        map.put("type", "success");
        map.put("msg", "添加成功");
        return map;
    }


    @RequestMapping(value = "/edit")
    @ResponseBody
    public Map<String, String> edit(Grade grade){
        Map<String, String> map = new HashMap<>();
        if(grade == null){
            map.put("type", "error");
            map.put("msg", "修改失败！！！");
            return map;
        }
        if(grade.getName() == null || grade.getName().isEmpty()){
            map.put("type", "error");
            map.put("msg", "年级名称不能为空！！！");
            return map;
        }
        System.out.println(grade);
        gradeService.updateGrade(grade);
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
//        String idsString = "";
//        for(Long id : ids){
//            idsString += id + ",";
//        }
//        idsString = idsString.substring(0, idsString.length()-1);
        String idsString = StringUtils.joinString(Arrays.asList(ids), ",");
        gradeService.deleteGrade(idsString);
        map.put("type", "success");
        map.put("msg", "删除成功");
        return map;
    }
}
