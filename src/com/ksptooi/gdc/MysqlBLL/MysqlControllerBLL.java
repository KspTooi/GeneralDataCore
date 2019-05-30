package com.ksptooi.gdc.MysqlBLL;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ksptooi.gdc.FileAPI.IOController_V5;
import com.ksptooi.gdc.MysqlDAL.MysqlDAO;
import com.ksptooi.gdc.Util.Var;

public class MysqlControllerBLL {

	
	IOController_V5 V5=null;
	MysqlDAO MD=null;
	
	
	public MysqlControllerBLL(){
		V5=new IOController_V5();
		MD=new MysqlDAO();
	}
	
	
	
	//从文件中加载Mysql连接信息
	public void loadConfigFromgdFile_MysqlBLL(File File){
		
		Var.LogManager.writeLogOfINFO("从配置文件读取数据库信息");
		
		String MysqlAddress=null;
		String DataBaseName=null;
		String MysqlUser=null;
		String MysqlPwd=null;
		String Param=null;
		
		
		V5.setTarget(File);
		
		MysqlAddress=V5.getKeyValue("MysqlAddress");
		DataBaseName=V5.getKeyValue("DataBaseName");
		MysqlUser=V5.getKeyValue("MysqlUser");
		MysqlPwd=V5.getKeyValue("MysqlPwd");
		Param=V5.getKeyValue("Param");
		
		//检查加载是否成功
		if(MysqlAddress == null){
			Var.LogManager.writeLogOfError("从配置文件读取数据库信息时错误! - 未找到Key:MysqlAddress");
			System.exit(0);
		}
		
		if(DataBaseName == null){
			Var.LogManager.writeLogOfError("从配置文件读取数据库信息时错误! - 未找到Key:DataBaseName");
			System.exit(0);
		}
		
		if(MysqlUser == null){
			Var.LogManager.writeLogOfError("从配置文件读取数据库信息时错误! - 未找到Key:MysqlUser");
			System.exit(0);
		}
		
		if(MysqlPwd == null){
			Var.LogManager.writeLogOfError("从配置文件读取数据库信息时错误! - 未找到Key:MysqlPwd");
			System.exit(0);
		}
		
		if(Param == null){
			Var.LogManager.writeLogOfError("从配置文件读取数据库信息时错误! - 未找到Key:Param");
			System.exit(0);
		}
		
		
		Var.mysql_URL="jdbc:mysql://"+MysqlAddress+"/"+DataBaseName+Param;
		Var.mysql_User=MysqlUser;
		Var.mysql_Pwd=MysqlPwd;
		
	}
	
	//执行查询语句
	public ResultSet query_MysqlBLL(String sql_Query){
		
		MD.getMysqlConnect();
		
		return MD.query(sql_Query);
		
	}
	
	
	//执行非查询语句
	public void noQuery_MysqlBLL(String sql_Update){
		
		MD.getMysqlConnect();
		
		MD.noQuery(sql_Update);
		
	}
	
	
	//检查某张表是否存在
	public boolean tableIsExists_MysqlBLL(String TableName){
		
		MD.getMysqlConnect();
		
		
		try {
			
			ResultSet rs=Var.mysql_Conn.getMetaData().getTables(null, null, TableName, null);
			
	         if (rs.next()) {  
	               return true;  
	         }else {  
	               return false;  
	         } 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			Var.LogManager.writeLogOfError("数据库连接错误！");
		}
		
		
		return false;
		
	}
	
	//获取数据库连接
	public Connection getMysqlConnect_BLL(){
		
		MD.getMysqlConnect();
		
		return Var.mysql_Conn;
	}
		
	
}
