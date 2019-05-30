package com.ksptooi.gdc.MysqlAPI;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import com.ksptooi.gdc.MysqlBLL.MysqlControllerBLL;

public class MysqlController {

	
	private String mysql_URL=null;
	
	private String mysql_User=null;
	
	private String mysql_Pwd=null;
	
	private MysqlControllerBLL MCB=null;
	
	public MysqlController(){
		
		mysql_URL=null;
		mysql_User=null;
		mysql_Pwd=null;
		MCB=new MysqlControllerBLL();
	}
	

	public String getMysql_URL() {
		return mysql_URL;
	}

	public void setMysql_URL(String mysql_URL) {
		this.mysql_URL = mysql_URL;
	}

	public String getMysql_User() {
		return mysql_User;
	}

	public void setMysql_User(String mysql_User) {
		this.mysql_User = mysql_User;
	}

	public String getMysql_Pwd() {
		return mysql_Pwd;
	}

	public void setMysql_Pwd(String mysql_Pwd) {
		this.mysql_Pwd = mysql_Pwd;
	}
	
	
	
	//从文件中加载Mysql连接信息
	public void loadConfigFromgdFile(File File){
		MCB.loadConfigFromgdFile_MysqlBLL(File);
	}
	
	
	//执行查询语句
	public ResultSet query(String sql_Query){
		return MCB.query_MysqlBLL(sql_Query);
	}
	
	//执行非查询语句
	public void noQuery(String sql_Update){
		MCB.noQuery_MysqlBLL(sql_Update);
	}
	
	//检查某张表是否存在
	public boolean tableIsExists(String TableName){
		return MCB.tableIsExists_MysqlBLL(TableName);
	}
	
	//获取数据库连接
	public Connection getMysqlConnect(){
		return MCB.getMysqlConnect_BLL();
	}
	
	
}
