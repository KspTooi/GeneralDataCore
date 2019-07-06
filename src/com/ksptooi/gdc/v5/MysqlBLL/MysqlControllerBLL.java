package com.ksptooi.gdc.v5.MysqlBLL;

import java.io.File;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ksptooi.gdc.Main.DataCore;
import com.ksptooi.gdc.v5.Manager.IOController_V5;
import com.ksptooi.gdc.v5.MysqlDAL.MysqlDAO;

/**
 * @author KspTooi
 * @deprecated
 */
public class MysqlControllerBLL {

	
	IOController_V5 V5=null;
	MysqlDAO MD=null;
	
	
	public MysqlControllerBLL(){
		V5=new IOController_V5();
		MD=new MysqlDAO();
	}
	
	
	
	//从文件中加载Mysql连接信息
	public void loadConfigFromgdFile_MysqlBLL(File File){
		
		DataCore.LogManager.logInfo("从配置文件读取数据库信息");
		
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
			DataCore.LogManager.logError("从配置文件读取数据库信息时错误! - 未找到Key:MysqlAddress");
			System.exit(0);
		}
		
		if(DataBaseName == null){
			DataCore.LogManager.logError("从配置文件读取数据库信息时错误! - 未找到Key:DataBaseName");
			System.exit(0);
		}
		
		if(MysqlUser == null){
			DataCore.LogManager.logError("从配置文件读取数据库信息时错误! - 未找到Key:MysqlUser");
			System.exit(0);
		}
		
		if(MysqlPwd == null){
			DataCore.LogManager.logError("从配置文件读取数据库信息时错误! - 未找到Key:MysqlPwd");
			System.exit(0);
		}
		
		if(Param == null){
			DataCore.LogManager.logError("从配置文件读取数据库信息时错误! - 未找到Key:Param");
			System.exit(0);
		}
		
		
		DataCore.mysql_URL="jdbc:mysql://"+MysqlAddress+"/"+DataBaseName+Param;
		DataCore.mysql_User=MysqlUser;
		DataCore.mysql_Pwd=MysqlPwd;
		
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
			
			ResultSet rs=DataCore.mysql_Conn.getMetaData().getTables(null, null, TableName, null);
			
	         if (rs.next()) {  
	               return true;  
	         }else {  
	               return false;  
	         } 
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			DataCore.LogManager.logError("数据库连接错误！");
		}
		
		
		return false;
		
	}
	
	//获取数据库连接
	public Connection getMysqlConnect_BLL(){
		
		MD.getMysqlConnect();
		
		return DataCore.mysql_Conn;
	}
		
	
}
