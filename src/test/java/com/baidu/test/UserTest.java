package com.baidu.test;

import com.baidu.action.UserAction;
import com.baidu.entity.User;
import com.baidu.mapper.UserMapper;
import com.baidu.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testSelectAllUser(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAllUsers();
        System.out.println("users = " + users);
        sqlSession.close();
    }
    @Test
    public void testInsert(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insert(new User(null,"xiao4hei","654321"));
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDelete(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteById(9);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testcount(){
        SqlSession sqlSession = MyBatisUtils.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer count = mapper.count();
        System.out.println("count = " + count);
        sqlSession.close();
    }
    @Test
    public void testAction(){
        UserAction action = new UserAction();
        action.execute();
    }
@Test
public void test2(){
    int a = 10;
    int b = 20;
}
}
