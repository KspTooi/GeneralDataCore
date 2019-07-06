package com.ksptooi.gdc.v5.MysqlDAL;

import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ksptooi.gdc.Main.DataCore;

/**
 * @author KspTooi
 * @deprecated
 */
public class MysqlDAO {


	public void getMysqlConnect(){
		
		if(DataCore.mysql_Conn != null){
			return ;
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			DataCore.LogManager.logError("未能找到Mysql驱动");
		}
		
		try {
			
			DataCore.LogManager.logInfo("连接到数据库");
			DataCore.LogManager.logInfo("URL:"+DataCore.mysql_URL);
			
			DataCore.mysql_Conn=DriverManager.getConnection(DataCore.mysql_URL,DataCore.mysql_User,DataCore.mysql_Pwd);
			
			DataCore.LogManager.logInfo("数据库连接成功");
			
		} catch (SQLException e) {
			e.printStackTrace();
			DataCore.LogManager.logError("建立Mysql数据库连接时出现错误!");
		}
		
	}
	
	
	
	public ResultSet query(String sql_Query){
		
		
		Statement stm=null;	
		ResultSet rs=null;
		
		try {
			
			
			stm=DataCore.mysql_Conn.createStatement();
			rs=stm.executeQuery(sql_Query);
			
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
			DataCore.LogManager.logError("Mysql数据库错误! - createStatement - query");
		}
		
		return null;
		
	}
	
	
	public void noQuery(String sql_Update){
		
		
		Statement stm=null;	
		
		try {
			
			
			stm=DataCore.mysql_Conn.createStatement();
			stm.executeUpdate(sql_Update);
			
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			DataCore.LogManager.logError("Mysql数据库错误! - createStatement - query");
		}
		
		
	}
	
	
}
