package com.yht.service;

import com.yht.entity.Grade;
import com.yht.entity.User;

import java.util.List;
import java.util.Map;

public interface IGradeService {
    Grade findByGradeName(String gradeName);
    void addGrade(Grade grade);
    List<Grade> findList(Map<String, Object> map);
    List<Grade> findAll();
    int getTotal(Map<String, Object> map);
    void updateGrade(Grade grade);
    void deleteGrade(String ids);

}
