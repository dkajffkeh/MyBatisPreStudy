package com.home.mybatis.common.template;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	// driver.properties 읽어들여서 생성했음.
	public static SqlSession getSqlSession() {
		//환경설정을 위한 메소드를 작성해줘야함.
		//mybatis-config.xml 읽어들이면서 생성할것.
		SqlSession sqlSession = null;
		try {
			InputStream is = Resources.getResourceAsStream("/mybatis-config.xml");
			sqlSession = new SqlSessionFactoryBuilder().build(is).openSession(false);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sqlSession;
	}
	
}
