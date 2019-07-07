package com.ksptooi.generalDebug;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ksptooi.gdc.Main.gdcList;
import com.ksptooi.gdc.v6.Manager.DataManager;
import com.ksptooi.gdc.v6.Manager.SqlSessionFactory;
import com.ksptooi.gdc.v6.Mysql.SqlSession;

public class debug {

	public static void main(String[] args) throws SQLException, IOException{
		
		
//		FileDAL_Input FDI=new FileDAL_Input();
//		FileDAL_OutPut FDO=new FileDAL_OutPut();
//		FileControllerBLL FCB=new FileControllerBLL();
//		
//		IOController_V5 V5=new IOController_V5();
//		File F=new File("F:/123.gd");
//		
//		V5.createNewGdcFile(F);
//		
//		V5.setTarget(F);
//		
//		V5.addLine("key1=5");
//		
//		System.out.println(V5.getKeyValue("@LineType"));
		
		
		ArrayList<String> al=new ArrayList<String>();
		
		
		File file = new File("C:/SSS/123.gd");
		
		DataManager v6 = new DataManager();
		
		v6.createGdc(file);
		
		v6.setTarget(file);

		
		
		
		
		
//		SqlSessionFactory SSF=new SqlSessionFactory();	
//				
//		SqlSession conn = SSF.getSqlSession();
//		
//		System.out.println("÷¥––≤È—Ø");
//		
//		
//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//		
//		while(true) {
//			
//			
//			conn.query(br.readLine());
//			
//			conn.release();
//			
//		}
		
		
	
		
	}

}
