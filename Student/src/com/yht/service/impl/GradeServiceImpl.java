package com.yht.service.impl;

import com.yht.dao.IGradeDao;
import com.yht.entity.Grade;
import com.yht.entity.User;
import com.yht.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl implements IGradeService {

    @Autowired
    private IGradeDao gradeDao;
    @Override
    public Grade findByGradeName(String gradeName) {
        return gradeDao.findByGradeName(gradeName);
    }

    @Override
    public void addGrade(Grade grade) {
        gradeDao.addGrade(grade);
    }

    @Override
    public List<Grade> findList(Map<String, Object> map) {
        return gradeDao.findList(map);
    }

    @Override
    public List<Grade> findAll() {
        return gradeDao.findAll();
    }

    @Override
    public int getTotal(Map<String, Object> map) {
        return gradeDao.getTotal(map);
    }

    @Override
    public void updateGrade(Grade grade) {
        gradeDao.updateGrade(grade);
    }

    @Override
    public void deleteGrade(String ids) {
        gradeDao.deleteGrade(ids);
    }
}
