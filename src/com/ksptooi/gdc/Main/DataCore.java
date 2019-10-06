package com.ksptooi.gdc.Main;

import java.sql.Connection;
import com.ksptooi.gdc.Log.LogManager;
import com.ksptooi.gdc.Log.gdcLog;

public class DataCore {

	
	
	public static void main(String[] args) {
		
		System.out.println("GeneralDataCore°æ±¾:"+DataCore.gdc_Version);
		
	}
	
	
	
	
	public static final String gdc_Version="V6.30-D";
	
	public static LogManager LogManager=new gdcLog();
		
	public static Connection mysql_Conn=null;
	
	public static String mysql_URL="jdbc:mysql://127.0.0.1:3306/fastlogin";
	
	public static String mysql_User="root";
	
	public static String mysql_Pwd="#";
	
	public static String getVersion() {
		return gdc_Version;
	}
	
	
}
