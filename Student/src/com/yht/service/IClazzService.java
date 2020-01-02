package com.yht.service;


import com.yht.entity.Clazz;

import java.util.List;
import java.util.Map;

public interface IClazzService {
    void addClazz(Clazz clazz);
    List<Clazz> findList(Map<String, Object> map);
    List<Clazz> findAll();
    int getTotal(Map<String, Object> map);
    void updateClazz(Clazz clazz);
    void deleteClazz(String ids);

}
