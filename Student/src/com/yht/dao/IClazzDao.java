package com.yht.dao;

import com.yht.entity.Clazz;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IClazzDao {
    void addClazz(Clazz clazz);
    List<Clazz> findList(Map<String, Object> map);
    int getTotal(Map<String, Object> map);
    void updateClazz(Clazz clazz);
    void deleteClazz(String ids);
    List<Clazz> findAll();
}
