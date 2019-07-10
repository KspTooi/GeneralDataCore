package com.ksptooi.generalDebug;

import java.io.File;

import com.ksptooi.gdc.v6.Factory.SqlSessionFactory;
import com.ksptooi.gdc.v6.Manager.GeneralDataFactoryBuilder;
import com.ksptooi.gdc.v6.Session.SqlSession;

public class debug {

	public static void main(String[] args){
		
		
		GeneralDataFactoryBuilder GDFB=new GeneralDataFactoryBuilder();
		
		
		
		SqlSessionFactory sessionFactory = GDFB.buildSqlFactory(new File("C://Connect.gd"));
		
		
		SqlSession sqlSession = sessionFactory.getSqlSession();
		
		
		sqlSession.query("select * from xxxx");
		
		
		sqlSession.noQuery("update xxxxx");
		
		
		sqlSession.release();
		
	}

}
