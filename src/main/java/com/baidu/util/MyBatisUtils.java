package com.baidu.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils{
	//创建SqlSessionFactory
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		//读取配置文件
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	//抽取前三步，返回sqlSession
	public static SqlSession openSession() {
		//获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
	
	//关闭资源
	public static void close(SqlSession sqlSession) {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
	public static void main(String args[]){
		System.out.println(openSession());
	}
}
