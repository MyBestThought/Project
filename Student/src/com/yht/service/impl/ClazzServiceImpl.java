package com.yht.service.impl;

import com.yht.dao.IClazzDao;
import com.yht.entity.Clazz;
import com.yht.service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class ClazzServiceImpl implements IClazzService {

    @Autowired
    private IClazzDao clazzDao;

    @Override
    public void addClazz(Clazz clazz) {
        clazzDao.addClazz(clazz);
    }

    @Override
    public List<Clazz> findList(Map<String, Object> map) {
        return clazzDao.findList(map);
    }

    @Override
    public List<Clazz> findAll() {
        return clazzDao.findAll();
    }

    @Override
    public int getTotal(Map<String, Object> map) {
        return clazzDao.getTotal(map);
    }

    @Override
    public void updateClazz(Clazz clazz) {
        clazzDao.updateClazz(clazz);
    }

    @Override
    public void deleteClazz(String ids) {
        clazzDao.deleteClazz(ids);
    }
}
