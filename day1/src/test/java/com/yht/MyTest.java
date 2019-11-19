package com.yht;

import com.yht.example1.dao.IUserDao;
import com.yht.example1.dao.impl.UserDaoImpl;
import com.yht.example1.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * 入门开发流程
 * 1，读取配置文件
 * 2，创建创建SqlSessionFactory对象
 * 3，使用工厂生产SqlSession对象
 * 4，创建dao接口的代理对象
 * 5，执行dao中的方法
 * 6，释放资源
 *
 */


/**
 * 自定义MyBatis的分析：
 * MyBatis在使用代理dao的方式
 *
 */

public class MyTest {
    public static void main(String[] args) throws Exception{
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(in);//构建者模式--把对象的创建细节隐藏，通过调用方法可以直接拿到对象
        //使用工厂生产SqlSession对象
        SqlSession session = sessionFactory.openSession();//工厂模式--解耦
        IUserDao dao = session.getMapper(IUserDao.class);//代理模式--不修改源码的基础上对已有方法进行增强
        //使用代理对象执行方法
        List<User> list = dao.findAll();
        System.out.println(list);
        //释放资源
        session.close();
        in.close();
    }
//    public static void main(String[] args) throws Exception{
//        //读取配置文件
//        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
//        //创建SqlSessionFactory对象
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory sessionFactory = builder.build(in);
//        //使用工厂生产SqlSession对象
//        IUserDao dao = new UserDaoImpl(sessionFactory);
//        //使用代理对象执行方法
//        List<User> list = dao.findAll();
//        System.out.println(list);
//        //释放资源
//        in.close();
//    }
}
