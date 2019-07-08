package com.ksptooi.generalDebug;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ksptooi.gdc.v6.Factory.SqlSessionFactory;
import com.ksptooi.gdc.v6.Manager.GeneralDataFactoryBuilder;
import com.ksptooi.gdc.v6.Session.SqlSession;

public class debug {

	public static void main(String[] args) throws SQLException, IOException{
		
		
		File file = new File("D:\\1219Ë÷Òý\\MineCraft Server\\1.7.10[PT]\\plugins\\ksptooi\\fastlogin\\FastLogin.conf");
		
		
		GeneralDataFactoryBuilder GDFB=new GeneralDataFactoryBuilder();
		
		SqlSessionFactory SqlFactory = GDFB.buildSqlFactory(file);
		
		
		SqlSession sqlSession = SqlFactory.getSqlSession();
		
		
		ResultSet query = sqlSession.query("select * from commands");
		
		
		
		
		
	}

}
