package com.ksptooi.gdc.v6.Manager;

import java.io.File;

import com.ksptooi.gdc.v6.Factory.DataSessionFactory;
import com.ksptooi.gdc.v6.Factory.SqlSessionFactory;
import com.ksptooi.gdc.v6.Session.dataSession;

public class GeneralDataFactoryBuilder {

	
	
	//构建DataSessionFactory
	
	public DataSessionFactory buildDataFactory(int SessionPoolSize) {
		
		return new DataSessionFactory(SessionPoolSize);	
		
	}
	
	
	
	//构建SqlSessionFactory
	public SqlSessionFactory buildSqlFactory(String address,String dbName,String user,String pwd,String param,int initSize) {
		
		SqlSessionFactory SSF=(SqlSessionFactory)new SqlSessionFactory(address, dbName, user, pwd, param, initSize);			
		return SSF;	
	}
	
	
	//从配置文件构建SqlSessionFactory
	public SqlSessionFactory buildSqlFactory(File file) {
		
		String address = null;

		String dbName = null;

		String userName = null;

		String password = null;

		String param = null;

		int poolInitSize = 16;
		
		//载入配置文件
		DataSessionFactory DataFactory = this.buildDataFactory(1);
		
		dataSession ds = DataFactory.openSession(file);
		
		address=ds.get("address");
		dbName=ds.get("database");
		userName=ds.get("username");
		password=ds.get("password");
		poolInitSize=ds.getInt("poolinitSize");
		param=ds.get("param");
		
		ds.release();
		DataFactory.destoryFactory();
		
		SqlSessionFactory SSF=(SqlSessionFactory)new SqlSessionFactory(address, dbName, userName, password, param, poolInitSize);	
		
		return SSF;	
		
	}
	
	
}
