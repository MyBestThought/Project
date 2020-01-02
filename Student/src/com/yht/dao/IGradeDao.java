package com.yht.dao;

import com.yht.entity.Grade;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IGradeDao {
    Grade findByGradeName(String gradeName);
    void addGrade(Grade grade);
    List<Grade> findList(Map<String, Object> map);
    int getTotal(Map<String, Object> map);
    void updateGrade(Grade grade);
    void deleteGrade(String ids);
    List<Grade> findAll();
}
