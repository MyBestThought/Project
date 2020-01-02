package com.yht.controller;

import com.yht.entity.Clazz;
import com.yht.entity.Grade;
import com.yht.page.Page;
import com.yht.service.IClazzService;
import com.yht.service.IGradeService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    private IClazzService clazzService;
    @Autowired
    private IGradeService gradeService;

    @RequestMapping(value = "/list")
    public ModelAndView list(ModelAndView model){

        model.setViewName("/clazz/clazzList");
        List<Grade> list = gradeService.findAll();
        model.addObject("gradeList", list);
        model.addObject("gradeListJson", JSONArray.fromObject(list));
        return model;

    }


    @RequestMapping(value = "/getList")
    @ResponseBody
    public Map<String, Object> getList(
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(value = "gradeId", required = false) Long gradeId,
            Page page
    ){
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> queryMap = new HashMap<>();
        queryMap.put("name", "%" + name +"%");
        if(gradeId != null){
            result.put("gradeId", gradeId);
        }
        System.out.println(gradeId + "=============");
        queryMap.put("offset", page.getOffset());
        queryMap.put("pageSize", page.getRows());
        result.put("rows", clazzService.findList(queryMap));
        result.put("total", clazzService.getTotal(queryMap));
        return result;
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public Map<String, Object> add(Clazz clazz){
        Map<String,Object> map = new HashMap<>();
        if(clazz == null){
            map.put("type", "error");
            map.put("msg", "数据添加出错，请联系管理员！！！");
            return map;
        }
        if(clazz.getName() == null || clazz.getName().isEmpty()){
            map.put("type", "error");
            map.put("msg", "班级名不能为空！！！");
            return map;
        }
        if(clazz.getGradeId() == null){
            map.put("type", "error");
            map.put("msg", "年级不能为空！！！");
            return map;
        }
        clazzService.addClazz(clazz);
        map.put("type", "success");
        map.put("msg", "添加成功");
        return map;
    }
    @RequestMapping(value = "/edit")
    @ResponseBody
    public Map<String, Object> edit(Clazz clazz){
        Map<String,Object> map = new HashMap<>();
        if(clazz == null){
            map.put("type", "error");
            map.put("msg", "数据修改出错，请联系管理员！！！");
            return map;
        }
        if(clazz.getName() == null || clazz.getName().isEmpty()){
            map.put("type", "error");
            map.put("msg", "班级名不能为空！！！");
            return map;
        }
        if(clazz.getGradeId() == null){
            map.put("type", "error");
            map.put("msg", "年级不能为空！！！");
            return map;
        }
        clazzService.updateClazz(clazz);
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
        clazzService.deleteClazz(idsString);
        map.put("type", "success");
        map.put("msg", "删除成功");
        return map;
    }

}
